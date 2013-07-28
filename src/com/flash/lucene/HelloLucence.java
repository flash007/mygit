package com.flash.lucene;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.*;
import org.apache.lucene.util.Version;

public class HelloLucence {

	//创建索引
	public void index(){
		//Directory directory = new RAMDirectory();  //索引保存在内存中
		Directory directory = null;
		try {
			directory = FSDirectory.open(new File("D:/lucence/index")); //索引创建在磁盘中
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_40); //分词器
		IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_40, analyzer); //配置
		IndexWriter writer = null; //写处理器
		
		try {
			 writer = new IndexWriter(directory, iwc);
			 
			 //创建document对象
			 Document doc = null;
			 File f = new File("D:/lucence/example");
			 for(File file : f.listFiles()){
				 doc = new Document();
				 doc.add(new Field("content", new FileReader(file)));
				 doc.add(new Field("filename",file.getName(),Field.Store.YES,Field.Index.NOT_ANALYZED));
				 doc.add(new Field("path",file.getAbsolutePath(),Field.Store.YES, Field.Index.NOT_ANALYZED));
				 
				 //通过IndexWriter将文档添加到索引中
				 writer.addDocument(doc);
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	//搜索
	public void search(){
		try {
			Directory directory = FSDirectory.open(new File("D:/lucence/index"));
			IndexReader reader = DirectoryReader.open(directory);
			IndexSearcher searcher = new IndexSearcher(reader);
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_40);
			QueryParser parser = new QueryParser(Version.LUCENE_40, "content", analyzer);
			Query query = parser.parse("5999");
			TopDocs tds = searcher.search(query, 1);
			ScoreDoc[] sds = tds.scoreDocs;
			for (ScoreDoc sd: sds){
				Document d = searcher.doc(sd.doc);
				System.out.println(d.get("filename")+d.get("path"));
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
}

package org.java.base.xml.dom;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DomDemo {
	
	private static String fileName = "F://temp/domTest.xml";
	
	public static void creatXml()
	{
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document document = builder.newDocument();
			
			Element root = document.createElement("employees");//创建一个xml文件根节点  
			document.appendChild(root);//把根节点加到xml文档结构下面  
			
			Element employee = document.createElement("employee");//创过employee节点  
			
			Element name = document.createElement("name");//创建name节点  
			name.appendChild(document.createTextNode("许三多"));//创建一个内容,并把内容加到name节点下面  
			employee.appendChild(name);
			
			Element sex = document.createElement("sex");//创建sex节点  
			sex.appendChild(document.createTextNode("男"));//创建一个内容,并把内容加到sex节点下面  
			sex.setAttribute("出生日期", "12");
			employee.appendChild(sex);
			
			Element age = document.createElement("age");//创建age节点  
			age.appendChild(document.createTextNode("22"));//创建一个内容,并把内容加到age节点下面  
			employee.appendChild(age);
			
			root.appendChild(employee);
			
			TransformerFactory tf = TransformerFactory.newInstance();   
			
			Transformer transformer = tf.newTransformer();   
            DOMSource source = new DOMSource(document);   
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");   
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");   
            PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));    
            StreamResult result = new StreamResult(pw);   
            transformer.transform(source, result);   
            System.out.println("生成XML文件成功!");   
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	

	public static void main(String[] args) {
		
		creatXml();
	}

}

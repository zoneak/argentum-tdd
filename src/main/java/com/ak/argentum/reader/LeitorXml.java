package com.ak.argentum.reader;

import java.io.InputStream;
import java.util.List;

import com.ak.argentum.modelo.Negociacao;
import com.ak.argentum.xstream.LocalDateTimeConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class LeitorXml {
	
	@SuppressWarnings("unchecked")
	public List<Negociacao> carrega(InputStream inputStream){
		
		XStream stream = new XStream(new DomDriver());
		stream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		stream.alias("negociacao", Negociacao.class);
	
		return (List<Negociacao>) stream.fromXML(inputStream);
		
	}

}

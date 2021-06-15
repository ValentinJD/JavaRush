package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringWriter;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            result = writer.toString();
            System.out.println(writer);
        }catch (JAXBException e){
            System.out.println("!!!!!!!!!!1");
        }


        return result.replaceAll(tagName, "<" + comment + ">" + "\n" + tagName);
    }

    public static void main(String[] args) {
        String ob =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                        "<shop>\n" +
                        "    <goods>\n" +
                        "        <names>S1</names>\n" +
                        "        <names>S2</names>\n" +
                        "    </goods>\n";
        String tagName = "goods";
        String comment = "<!--it's a comment-->";
        String str = toXmlWithComment(ob, tagName, comment);
        System.out.println(str);
    }
}

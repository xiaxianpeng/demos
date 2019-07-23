package xstream;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author 夏先鹏
 * @date 2019/07/23
 * @time 16:04
 */
public class XstreamUtil {

    public static Object xmlToBean(Class<?> clazz, String xmlPath) {
        Object xmlObject = null;
        XStream xStream = new XStream();
        xStream.processAnnotations(clazz);
        xStream.autodetectAnnotations(true);
        File file = new File(xmlPath);
        xmlObject = xStream.fromXML(file);
        System.out.println("xml obj : " + xmlObject);
        return xmlObject;
    }

    public static void beanToXml(Object obj) throws IOException {
        XStream xStream = new XStream();
        xStream.processAnnotations(obj.getClass());
        Writer writer = new FileWriter("src/main/java/xstream/copyCitys.xml");
        xStream.toXML(obj, writer);
    }

    public static void main(String[] args) throws IOException {
        Object obj = xmlToBean(CityList.class, "src/main/java/xstream/citys.xml");
        beanToXml(obj);
    }
}

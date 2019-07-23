package xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 夏先鹏
 * @date 2019/07/23
 * @time 15:43
 *
 *
 * 简介
 * Xstream是一种OXMapping 技术，是用来处理XML文件序列化的框架,在将JavaBean序列化，或将XML文件反序列化的时候，不需要其它辅助类和映射文件，使得XML序列化不再繁索。Xstream也可以将JavaBean序列化成Json或反序列化，使用非常方便。
 * 主要使用
 * @XStreamAlias(“alis”)java对象在xml中以标签的形式显示时，如果名字与类名或者属性名不一致，可以使用该标签并在括号内注明别名。
 * @XStreamOmitField在输出XML的时候忽略该属性
 * @XStreamImplicit如果该属性是一个列表或者数组，在XML中不显示list或者Array字样
 * @XStreamAsAttribute该属性不单独显示成XML节点，而是作为属性显示出来
 * @XStreamContainedType
 * @XStreamConverter设置转换器
 * @XStreamConverters converter主要用于将某些字段进行复杂的转换，转换过程写在一个类中。
 * 然后将其注册到XStream。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XStreamAlias("city")
public class City {

    @XStreamAsAttribute
    @XStreamAlias("cityId")
    private String cityId;

    @XStreamAsAttribute
    @XStreamAlias("cityName")
    private String cityName;

    @XStreamAsAttribute
    @XStreamAlias("cityCode")
    private String cityCode;

    @XStreamAsAttribute
    @XStreamAlias("province")
    private String province;
}

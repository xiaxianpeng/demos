package xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 夏先鹏
 * @date 2019/07/23
 * @time 15:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XStreamAlias("citys")
public class CityList {

    @XStreamImplicit(itemFieldName = "city")
    private List<City> cityList;

}

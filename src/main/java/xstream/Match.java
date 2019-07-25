package xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * @author 夏先鹏
 * @date 2019/07/25
 * @time 11:27
 */
@XStreamAlias("tournament")
public class Match {

    @XStreamAlias("tournament")
    private Tournament tournament;


    public class Tournament {

        @XStreamAlias("id")
        @XStreamAsAttribute
        private String id;

        @XStreamAlias("name")
        @XStreamAsAttribute
        private String name;

        @XStreamAlias("sport")
        private Sport sport;
        @XStreamAlias("category")
        private Category category;

    }


    public class Sport {

        @XStreamAlias("id")
        @XStreamAsAttribute
        private String id;

        @XStreamAlias("name")
        @XStreamAsAttribute
        private String name;
    }

    public class Category {

        @XStreamAlias("id")
        @XStreamAsAttribute
        private String id;

        @XStreamAlias("name")
        @XStreamAsAttribute
        private String name;

        @XStreamAlias("country_code")
        @XStreamAsAttribute
        private String countryCode;
    }
}

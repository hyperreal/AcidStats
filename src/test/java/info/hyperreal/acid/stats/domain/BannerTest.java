package info.hyperreal.acid.stats.domain;

import info.hyperreal.acid.stats.domain.entities.Banner;
import junit.framework.Assert;
import org.junit.Test;

public class BannerTest {

    @Test
    public void getters() throws Exception {
        Banner banner = new Banner(1, "name");
        Assert.assertEquals("1", banner.getId());
        Assert.assertEquals("name", banner.getName());
    }
}

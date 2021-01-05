package data.structure.graph;

import com.apple.eawt.Application;
import data.structure.StructureApplication;
import data.structure.graph.impl.AdjacentListGraphImpl;
import data.structure.graph.model.GraphType;
import data.structure.graph.model.TripleExtend;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * AdjacentMatrixTest:
 * 邻接矩阵测试类
 *
 * @author sunchen
 * @date 2020/5/29 4:57 下午
 */
public class AdjacentListTest {
    AdjacentListGraphImpl matrixDirect;

    String[] verTexs;
    TripleExtend[] triples;

    @Before
    public void init() {
        verTexs = new String[]{
                "V1",
                "V2",
                "V3",
                "V4",
                "V5"
        };

        triples = new TripleExtend[]{
                new TripleExtend("V1", "V2", 1),
                new TripleExtend("V1", "V4", 1),
                new TripleExtend("V2", "V3", 1),
                new TripleExtend("V2", "V1", 1),
                new TripleExtend("V4", "V3", 1),
                new TripleExtend("V3", "V5", 1),
                new TripleExtend("V5", "V4", 1),
        };

        matrixDirect = new AdjacentListGraphImpl(GraphType.Directed, verTexs, triples);
        Integer[][] array = new Integer[][]{
                new Integer[]{0, 1, 0, 1, 0},
                new Integer[]{1, 0, 1, 0, 0},
                new Integer[]{0, 0, 0, 0, 1},
                new Integer[]{0, 0, 1, 0, 0},
                new Integer[]{0, 0, 0, 1, 0},
        };
        Assert.assertArrayEquals(matrixDirect.toArray(), array);
    }

    @Test
    public void locateVex() {
        int index = matrixDirect.locateVex("V3");
        Assert.assertEquals(2, index);
    }

    @Test
    public void firstAdjVex() {
        Object v = matrixDirect.firstAdjVex("V1");
        Assert.assertEquals("V4", v);
    }

    @Test
    public void nextAdjVex() {
        Object v = matrixDirect.nextAdjVex("V1", "V4");
        Assert.assertEquals("V2", v);
    }

    @Test
    public void insertVex() {
        matrixDirect.insertVex("V6");
        String verName = "V1,V2,V3,V4,V5,V6";
        Assert.assertEquals(verName, matrixDirect.toString());
    }

    @Test
    public void deleteVex() {
        matrixDirect.deleteVex("V3");
        String verName = "V1,V2,V4,V5";
        Assert.assertEquals(verName, matrixDirect.toString());
        Integer[][] array = new Integer[][]{
                new Integer[]{0, 1, 1, 0},
                new Integer[]{1, 0, 0, 0},
                new Integer[]{0, 0, 0, 0},
                new Integer[]{0, 0, 1, 0},
        };
        Assert.assertArrayEquals(matrixDirect.toArray(), array);
    }

    @Test
    public void insertArc() {
        TripleExtend data7 = new TripleExtend("V2", "V4");
        matrixDirect.insertArc(data7);
        Integer[][] array = new Integer[][]{
                new Integer[]{0, 1, 0, 1, 0},
                new Integer[]{1, 0, 1, 1, 0},
                new Integer[]{0, 0, 0, 0, 1},
                new Integer[]{0, 0, 1, 0, 0},
                new Integer[]{0, 0, 0, 1, 0},
        };
        Assert.assertArrayEquals(matrixDirect.toArray(), array);
    }

    @Test
    public void deleteArc() {
        matrixDirect.deleteArc("V1", "V2");
        Integer[][] array = new Integer[][]{
                new Integer[]{0, 0, 0, 1, 0},
                new Integer[]{1, 0, 1, 0, 0},
                new Integer[]{0, 0, 0, 0, 1},
                new Integer[]{0, 0, 1, 0, 0},
                new Integer[]{0, 0, 0, 1, 0},
        };
        Assert.assertArrayEquals(matrixDirect.toArray(), array);
    }

    @Test
    public void dfs() {
        matrixDirect.dfsTraverse();
        List<String> list = Lists.newArrayList();
        list.add("V1");
        list.add("V4");
        list.add("V3");
        list.add("V5");
        list.add("V2");
        Assert.assertEquals(matrixDirect.data, list);
    }

    @Test
    public void bfs() {
        matrixDirect.bfsTraverse();
        List<String> list = Lists.newArrayList();
        list.add("V1");
        list.add("V4");
        list.add("V2");
        list.add("V3");
        list.add("V5");
        Assert.assertEquals(matrixDirect.data, list);
    }
}

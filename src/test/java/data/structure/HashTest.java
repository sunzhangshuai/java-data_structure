package data.structure;

import data.structure.searchtable.hashtable.confictmanage.LinearProbing;
import data.structure.searchtable.hashtable.confictmanage.QuadraticProbing;
import data.structure.searchtable.hashtable.confictmanage.RandomProbing;
import data.structure.searchtable.hashtable.confictmanage.ReHash;
import data.structure.searchtable.hashtable.hash.ModHash;
import data.structure.searchtable.hashtable.table.DoubleHashingImpl;
import data.structure.searchtable.hashtable.table.LinkedHashTableImpl;
import data.structure.searchtable.hashtable.table.OpenAddressingImpl;
import data.structure.searchtable.model.Element;
import org.junit.Assert;
import org.junit.Test;

/**
 * HashTest:
 *
 * @author sunchen
 * @date 2020/7/12 7:32 下午
 */
public class HashTest {

    @Test
    public void linkedHash() {
        LinkedHashTableImpl hashTable = new LinkedHashTableImpl(ModHash.getInstance());
        hashTable.insert(new Element(1, "laopo"));
        hashTable.insert(new Element(98, "laogong"));
        Assert.assertEquals(hashTable.search(98).value, "laogong");
        hashTable.delete(1);
        Assert.assertNull(hashTable.search(1));
    }
    @Test
    public void linearProbHash(){
        OpenAddressingImpl openAddressing = new OpenAddressingImpl(new LinearProbing(), ModHash.getInstance());
        openAddressing.insert(new Element(1, "laopo"));
        openAddressing.insert(new Element(98, "laogong"));
        Assert.assertEquals(openAddressing.search(98).value, "laogong");
        openAddressing.delete(1);
        Assert.assertNull(openAddressing.search(1));
    }

    @Test
    public void quadraticProbHash(){
        OpenAddressingImpl openAddressing = new OpenAddressingImpl(new QuadraticProbing(), ModHash.getInstance());
        openAddressing.insert(new Element(1, "laopo"));
        openAddressing.insert(new Element(98, "laogong"));
        Assert.assertEquals(openAddressing.search(98).value, "laogong");
        openAddressing.delete(1);
        Assert.assertNull(openAddressing.search(1));
    }

    @Test
    public void RandomProbHash(){
        OpenAddressingImpl openAddressing = new OpenAddressingImpl(new RandomProbing(), ModHash.getInstance());
        openAddressing.insert(new Element(1, "laopo"));
        openAddressing.insert(new Element(98, "laogong"));
        Assert.assertEquals(openAddressing.search(98).value, "laogong");
        openAddressing.delete(1);
        Assert.assertNull(openAddressing.search(1));
    }
    @Test
    public void reHash(){
        DoubleHashingImpl doubleHashing = new DoubleHashingImpl(ModHash.getInstance());
        doubleHashing.insert(new Element(1, "laopo"));
        doubleHashing.insert(new Element(98, "laogong"));
        Assert.assertEquals(doubleHashing.search(98).value, "laogong");
        doubleHashing.delete(1);
        Assert.assertNull(doubleHashing.search(1));
    }
}

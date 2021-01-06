package data.structure.searchtable.hashtable.confictmanage;

import data.structure.searchtable.hashtable.hash.DigitalAnalysis;
import data.structure.searchtable.hashtable.hash.DirectAddressing;
import data.structure.searchtable.hashtable.hash.Folding;
import data.structure.searchtable.hashtable.hash.HashFunction;
import data.structure.searchtable.hashtable.hash.MedianSquare;
import data.structure.searchtable.hashtable.hash.ModHash;
import data.structure.searchtable.hashtable.hash.RandomNumber;
import data.structure.searchtable.hashtable.table.AbstractHashTable;

/**
 * ReHash:
 *
 * @author sunchen
 * @date 2020/7/12 10:22 下午
 */
public class ReHash extends Probing {

    HashFunction[] hashList;

    public ReHash() {
        hashList = new HashFunction[]{
                DigitalAnalysis.getInstance(),
                DirectAddressing.getInstance(),
                Folding.getInstance(),
                MedianSquare.getInstance(),
                MedianSquare.getInstance(),
                ModHash.getInstance(),
                RandomNumber.getInstance()
        };
    }

    @Override
    public int getMaxConflict(AbstractHashTable hashTable) {
        return hashList.length-1;
    }

    @Override
    public int next(int index, int conflict, AbstractHashTable hashTable, Object key) {
        HashFunction hashFunction = hashList[conflict];
        return hashFunction.handle(hashTable, key);
    }
}

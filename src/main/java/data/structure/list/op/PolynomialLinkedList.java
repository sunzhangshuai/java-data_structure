package data.structure.list.op;

import data.structure.list.impl.SingleLinkedListImpl;
import data.structure.list.model.Term;

/**
 * 一元多项式 两个项的指数相比
 */
public class PolynomialLinkedList extends SingleLinkedListImpl {

    @Override
    public boolean compare(Object data, Object e){
        return ((Term)data).expn >= ((Term)e).expn;
    }

}

package data.structure.queue.model;

import data.structure.list.model.ListNode;

/**
 * @author wenba
 */
public class QueueNode extends ListNode {

    public QueueNode next;
    public QueueNode prev;

    /**
     * 构造器
     *
     * @param data
     */
    public QueueNode(Object data) {
        super(data);
    }
}

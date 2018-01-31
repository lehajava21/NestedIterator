import java.util.*;

public class NestedIterator implements Iterable {

    private Class clazz;
    private Stack<Object> stack;
    private Object next;
    List<Object> list;
    Iterator<Object> iter;

    public NestedIterator(Class clazz,Object...objects){
        this.clazz = clazz;
        stack = new Stack();
        list = Arrays.asList(objects);
        iter = list.iterator();
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator {

        @Override
        public boolean hasNext() {
            Object o = null;
            if(stack.empty() && iter.hasNext()) {
                o = iter.next();
            }
            if(!stack.empty()){
                o = stack.pop();
            }
            if(o == null){
                return false;
            }
            while(true)
            {
                if(o.getClass().isArray()){
                    for(Object arrobj : (Object[])o){
                        stack.push(arrobj);
                    }
                }else if(Collection.class.isInstance(o)){
                    for(Object collobj : (Collection)o){
                        stack.push(collobj);
                    }
                }else {
                    if(clazz.isInstance(o)){
                        next = o;
                        return true;
                    }
                }
                if(stack.empty()){
                    return false;
                }
                o = stack.pop();
            }
        }

        @Override
        public Object next() {
            return next;
        }
    }

}

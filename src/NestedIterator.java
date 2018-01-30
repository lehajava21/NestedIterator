import java.util.*;

public class NestedIterator implements Iterable {

    private Class clazz;
    private Object[] objects;
    private List list;

    public NestedIterator(Class clazz,Object...objects){
        this.clazz = clazz;
        this.objects = objects;
        list = checkObjects();
    }

    private List checkObjects(){
        Stack<Object> stack = new Stack();
        List res = new ArrayList();
        for(Object o : objects){
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
                        res.add(o);
                    }
                }
                if(stack.empty()){
                    break;
                }
                o = stack.pop();
            }
        }
        return res;
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }

}

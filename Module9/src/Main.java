
public class Main {
    public static void main(String[] args) {
        System.out.println("_____________myArrayList_____________");
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("3");
        System.out.println(myArrayList);
        myArrayList.get(2);
        myArrayList.size();

        myArrayList.add("4");
        myArrayList.add("5");
        System.out.println(myArrayList);
        myArrayList.remove(0);
        System.out.println(myArrayList);
        myArrayList.size();
        myArrayList.add("6");
        myArrayList.add("7");
        myArrayList.clear();
        System.out.println(myArrayList);

        System.out.println("_____________myLinkedList_____________");
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");
        System.out.println(myLinkedList);
        myLinkedList.size();
        myLinkedList.add("4");
        myLinkedList.add("5");
        myLinkedList.add("6");
        myLinkedList.add("7");
        myLinkedList.remove(1);
        System.out.println(myLinkedList);
        myLinkedList.clear();
        System.out.println(myLinkedList);
        myLinkedList.size();

        System.out.println("______________MyQueue______________");
        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.add("1");
        myQueue.add("2");
        myQueue.size();
        System.out.println(myQueue);
        myQueue.peek();
        myQueue.add("3");
        myQueue.size();
        myQueue.poll();
        myQueue.peek();
        myQueue.size();
        System.out.println(myQueue);
        myQueue.poll();
        System.out.println(myQueue);
        myQueue.clear();
        System.out.println(myQueue);

        System.out.println("______________MyStack______________");
        MyStack myStack = new MyStack();
        myStack.push("Andrey");
        myStack.push("Misha");
        myStack.push("Alex");
        myStack.push("Roma");
        System.out.println(myStack);
        myStack.size();
        myStack.remove(0);
        System.out.println(myStack);
        myStack.size();
        myStack.pop();
        myStack.size();
        System.out.println(myStack);
        myStack.pop();
        myStack.size();
        System.out.println(myStack);

        System.out.println("_______________HashMap___________");
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put("key1", "value1");
        myHashMap.put("key2", "value2");
        myHashMap.put("key3", "value3");
        myHashMap.put("key4", "value4");
        myHashMap.put("key5", "value5");
        myHashMap.size();
        myHashMap.clear();
    }
}
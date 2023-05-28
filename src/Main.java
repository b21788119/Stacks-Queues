
public class Main {
    public static void main(String[] args){        
        String commandFile = args[0];
        String[] stackData = Reader.readFile("stack.txt");
        String[] queueData = Reader.readFile("queue.txt");
        BasicStack basicStack = new BasicStack();
        BasicQueue basicQueue = new BasicQueue();          
        
        String[] splittedLine1 = stackData[0].split("\\s+");
        String[] splittedLine2 = queueData[0].split("\\s+");
        for(int i = splittedLine1.length-1;i>=0;i--){
            Integer number = Integer.valueOf(splittedLine1[i]);
            basicStack.push(number);
        }
        for(String s : splittedLine2){
            Integer number = Integer.valueOf(s);
            basicQueue.offer(number);
        }  
        Runner Runner = new Runner(basicStack, basicQueue,"stack.txt","queue.txt");
        Runner.Run(commandFile);
}
}

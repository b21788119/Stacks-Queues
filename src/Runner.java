
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Runner {
    private BasicStack stack;
    private BasicQueue queue;
    private String stackInterface = "";
    private String queueInterface = "";
    private String relatedFile1;
    private String relatedFile2;

    public Runner(BasicStack stack, BasicQueue queue,String relatedFile1,String relatedFile2) {
        this.stack = stack;
        this.queue = queue;
        this.relatedFile1 = relatedFile1;
        this.relatedFile2 = relatedFile2;
    } 
    public void Run(String commandFile){
        String[] commandDatas = Reader.readFile(commandFile);
        for(String s : commandDatas){
            String[] splittedLine = s.split("\\s+");
            String dataType = splittedLine[0];
            String operation = splittedLine[1];
            if(dataType.equals("S")){
                switch(operation){
                    case "removeGreater" :
                        int number = Integer.parseInt(splittedLine[2]);
                        removeGreater(number,1);
                        stackInterface+= "After removeGreater "+number+":\n"+this.stack.display()+"\n";
                        break;
                    case "calculateDistance":
                        int distance = calculateDistance(1);
                        stackInterface+= "After calculateDistance:\nTotal distance="+distance+"\n";
                        break;
                    case "addOrRemove":
                        int command = Integer.parseInt(splittedLine[2]);
                        addOrRemove(command,1);
                        stackInterface+= "After addOrRemove "+command+":\n"+this.stack.display()+"\n";
                        break;
                    case "reverse":
                        int k = Integer.parseInt(splittedLine[2]);
                        reverseElements(k, 1);
                        stackInterface+= "After reverse "+k+":\n"+this.stack.display()+"\n";
                        break;
                    case "sortElements":
                        sort(1);
                        this.stack.reverse(this.stack.size());
                        stackInterface+= "After sortElements:\n"+this.stack.display()+"\n";
                        break;
                    case "distinctElements":
                        int distinct = distinctElements(1);
                        stackInterface+= "After distinctElements:\nTotal distinct element="+distinct;
                        break;
                }
            }
            else if(dataType.equals("Q")){
                switch(operation){
                    case "removeGreater" :
                        int number = Integer.parseInt(splittedLine[2]);
                        removeGreater(number,2);
                        queueInterface+= "After removeGreater "+number+":\n"+this.queue.display()+"\n";
                        break;
                    case "calculateDistance":
                        int distance = calculateDistance(2);
                        queueInterface+= "After calculateDistance:\nTotal distance="+distance+"\n";
                        break;
                    case "addOrRemove":
                        int command = Integer.parseInt(splittedLine[2]);
                        addOrRemove(command,2);
                        queueInterface+= "After addOrRemove "+command+":\n"+this.queue.display()+"\n";
                        break;
                    case "reverse":
                        int k = Integer.parseInt(splittedLine[2]);
                        reverseElements(k, 2);
                        queueInterface+= "After reverse "+k+":\n"+this.queue.display()+"\n";
                        break;
                    case "sortElements":
                        sort(2);
                        queueInterface+= "After sortElements:\n"+this.queue.display()+"\n";
                        break;
                    case "distinctElements":
                        int distinct = distinctElements(2);
                        queueInterface+= "After distinctElements:\nTotal distinct element="+distinct;
                        break;
                }
            }
        }
        updateRelatedFiles(1);
        updateRelatedFiles(2);
        createOutput(2);
        createOutput(1); 
    }
    public void updateRelatedFiles(int command){
        class updateTool{
            public void clean(String file){
                try {
                    FileWriter writer = new FileWriter(file,false);
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            public void writeContent(String file,String content){
                FileWriter writer1;
                try {
                    writer1 = new FileWriter(file,true);
                    writer1.write(content);
                    writer1.close();
                } catch (IOException ex) {
                    Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        updateTool updater = new updateTool();
        if(command == 1){
            updater.clean(relatedFile1);
            updater.writeContent(relatedFile1,this.stack.display());
        }
        else if(command == 2){
            updater.clean(relatedFile2);
            updater.writeContent(relatedFile2,this.queue.display());
        }
    }
    public void createOutput(int command){
        if(command == 1){
            File file = new File("stackOut.txt");
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(stackInterface);
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (command == 2){
            File file = new File("queueOut.txt");
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(queueInterface);
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    public void removeGreater(int number,int command){
        if(command == 1){
            BasicStack basicStack = new BasicStack();
            for(Integer i : this.stack){
                if(i.compareTo(number)<=0){
                    basicStack.push(i);
                }
            }
            this.stack = basicStack;
        }
        else if(command == 2){
            BasicQueue updatedQueue = new BasicQueue();
            for(Integer i : this.queue){
                if(i.compareTo(number)<=0){
                    updatedQueue.offer(i);
                }
            }
            this.queue = updatedQueue;
        }
    }
    public int calculateDistance(int command){
        if(command == 1){
            int distance = 0;
            Integer[] ourData = this.stack.toArray();
            
            int index = 0;
            
            while(true){
            
                if(index == ourData.length-1){
                    break;
                }    
                
                for(int i = index+1;i<ourData.length;i++){
                    int number1 = (ourData[index]);
                    int number2 = (ourData[i]);
                    distance += Math.abs(number1-number2);
                }
                index++;
            }
            return distance;
        }
        else if(command == 2){
            int distance = 0;
            Integer[] ourData = this.queue.toArray();
            
            int index = 0;
            
            while(true){
            
                if(index == ourData.length-1){
                    break;
                }    
                
                for(int i = index+1;i<ourData.length;i++){
                    int number1 = (ourData[index]);
                    int number2 = (ourData[i]);
                    distance += Math.abs(number1-number2);
                }
                index++;
            }
            return distance;
        }
        else{
            return -1;
        }
    }
    
    public void addOrRemove(int operation,int command){
    
        switch(command){
            case 1 :
                if(operation < 0){
                    int number = Math.abs(operation);
                    for(int i = 0;i<number;i++){
                        this.stack.pop();
                    }
                }
                else if(operation > 0){
                    Random random = new Random();
                    for(int j=0;j<operation;j++){
                        this.stack.push(random.nextInt(50));
                    }
                }
                break;
            case 2 :
                if(operation < 0){
                    int number = Math.abs(operation);
                    try{
                        for(int i=0;i<number;i++){
                            this.queue.poll();
                        }
                    }
                    catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                }
                else if(operation > 0){
                    Random random = new Random();
                    try{
                        for(int j=0;j<operation;j++){
                            this.queue.offer(random.nextInt(50));
                        }
                    }
                    catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                }
                break;
        }
    }
    public void reverseElements(int k,int command){
        if(command == 1){
            this.stack.reverse(k);
        }
        else if(command == 2){
            this.queue.reverse(k);
        }
    }
    public void sort(int command){
        if(command == 1){
            this.stack.sort();
        }
        else if(command == 2){
            this.queue.sort();
        }
    }
    public int distinctElements(int command){
        if(command == 1){
            BasicStack  controller = new BasicStack();
            for(Integer i  : this.stack){
                if(controller.contains(i)){
                    continue;
                }
                else{
                    controller.push(i);
                }
            }
            return (controller.size());
        }
        else if(command == 2){
            BasicQueue  controller = new BasicQueue();
            
            for(Integer i  : this.queue){
                if(controller.contains(i)){
                    continue;
                }
                else{
                    controller.offer(i);
                }
            }
            return (controller.size());
        
        
        }
        return -1;
    }
    
    
}

package base.pages.workflow;

public class ApproveNode {
    String username;
    String uid;
    String type;
    boolean isLastNode;
    public ApproveNode(String username,String uid,String type,boolean isLastNode){
        this.username = username;
        this.uid = uid;
        this.type = type;
        this.isLastNode = isLastNode;
    }

    public String getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getType() {
        return type;
    }

    public boolean isLastNode() {
        return isLastNode;
    }
}

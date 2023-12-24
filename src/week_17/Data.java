package week_17;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    @JsonProperty("sha")
    private String sha;
    @JsonProperty("node_id")
    private String node_id;

    private Commit commit;

    public Data() {
    }

    public Data(String sha, String node_id, Commit commit) {
        this.sha = sha;
        this.node_id = node_id;
        this.commit = commit;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    @Override
    public String toString() {
        return "______________________________________________________" +
                "\nsha='" + sha + "" +
                "\ncommit=" + getCommit().getAuthor().getName() + "" +
                "\nmessage=" + getCommit().getMessage() + "" +
                "\ndate=" + getCommit().getAuthor().getDate() + "" +
                "\n";
    }
}

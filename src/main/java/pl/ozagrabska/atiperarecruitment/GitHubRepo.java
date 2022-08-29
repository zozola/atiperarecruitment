package pl.ozagrabska.atiperarecruitment;

class GitHubOwner {
    public int id;
    public String login;
}

public class GitHubRepo {
    public int id;
    public String name;
    public String full_name;
    public Boolean fork;
    public String branches_url;
    public GitHubOwner owner;
}

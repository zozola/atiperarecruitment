package pl.ozagrabska.atiperarecruitment;

import java.util.ArrayList;

public class ResultData {
    public String name;
    public String owner;
    public ArrayList<ResultBranch> branches;

    public ResultData() {
        this.branches = new ArrayList<ResultBranch>();
    }
}

package com.sqrrow.metric;

import com.sqrrow.entity.CKNumber;
import com.sqrrow.entity.CKReport;


import java.util.HashMap;
import java.util.Map;

public class NOCExtras {

    private Map<String, Integer> toAdd;

    public NOCExtras() {
        toAdd = new HashMap<>();
    }

    public void plusOne(String clazz) {
        if(clazz.equals("java.lang.Object"))
            return;

        if(!toAdd.containsKey(clazz))
            toAdd.put(clazz, 0);

        toAdd.put(clazz, toAdd.get(clazz) + 1);
    }

    public void update(CKReport report) {
        for(Map.Entry<String, Integer> kv : toAdd.entrySet()) {
            CKNumber ck = report.getByClassName(kv.getKey());
            if(ck!=null) ck.incNoc(kv.getValue());
        }
    }
}

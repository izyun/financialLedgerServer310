package com.example.financialLedgerServer310.service;

import java.util.List;
import java.util.Map;

public interface LedgerService {
    public List<Map<String, Object>> selectFinancialLedger(int y, int m);

}

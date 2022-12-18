package com.example.financialLedgerServer310.service;

import com.example.financialLedgerServer310.repository.LedgerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LedgerServiceImpl implements LedgerService {
    private LedgerRepository ledgerRepository;
    @Autowired
    public LedgerServiceImpl() {
        this.ledgerRepository = ledgerRepository;
    }

    @Override
    public List<Map<String, Object>> selectFinancialLedger(int y, int m) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		/*
		 SELECT
		 	cashbook_no cashbookNo
		 	,DAY(cash_date) day
		 	,kind
		 	,cash
		 	,LEFT(memo, 5) memo
		 FROM cashbook
		 WHERE YEAR(cash_date) = ? AND MONTH(cash_date) = ?
		 ORDER BY DAY(cash_date) ASC, kind ASC
		 */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT"
                + "		 	cashbook_no cashbookNo"
                + "		 	,DAY(cash_date) day"
                + "		 	,kind"
                + "		 	,cash"
                + "			,LEFT(memo, 5) memo"
                + "		 FROM cashbook"
                + "		 WHERE YEAR(cash_date) = ? AND MONTH(cash_date) = ?"
                + "		 ORDER BY DAY(cash_date) ASC, kind ASC";
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cashbook","root","1qaz");
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, y);
            stmt.setInt(2, m);
            rs = stmt.executeQuery();
            while(rs.next()) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("cashbookNo", rs.getInt("cashbookNo"));
                map.put("day", rs.getInt("day"));
                map.put("kind", rs.getString("kind"));
                map.put("cash", rs.getInt("cash"));
                map.put("memo", rs.getString("memo"));
                list.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}

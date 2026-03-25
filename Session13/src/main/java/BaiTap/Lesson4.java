package BaiTap;

import java.sql.*;
import java.util.*;

public class DashboardDAO {
    public List<BenhNhanDTO> getDanhSachBenhNhan() {
        List<BenhNhanDTO> result = new ArrayList<>();
        Map<Integer, BenhNhanDTO> map = new LinkedHashMap<>();
        String sql = """
                SELECT bn.id, bn.ten,
                       dv.id AS dv_id, dv.ten AS dv_ten
                FROM BenhNhan bn
                LEFT JOIN DichVuSuDung dv
                ON bn.id = dv.maBenhNhan
                """;
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int maBN = rs.getInt("id");
                BenhNhanDTO bn = map.get(maBN);
                if (bn == null) {
                    bn = new BenhNhanDTO();
                    bn.setMaBenhNhan(maBN);
                    bn.setTen(rs.getString("ten"));
                    bn.setDsDichVu(new ArrayList<>());
                    map.put(maBN, bn);
                }
                int dvId = rs.getInt("dv_id");
                if (!rs.wasNull()) {
                    DichVu dv = new DichVu();
                    dv.setId(dvId);
                    dv.setTen(rs.getString("dv_ten"));
                    bn.getDsDichVu().add(dv);
                }
            }

            result.addAll(map.values());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
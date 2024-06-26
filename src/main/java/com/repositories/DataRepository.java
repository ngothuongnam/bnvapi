package com.repositories;

import com.config.DatabaseConnector;
import com.models.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataRepository implements IRepository<Data>{
    @Autowired
    private DatabaseConnector databaseConnector;

    @Override
    public List<Data> getAll() {
        List<Data> dataList = new ArrayList<>();
        Connection conn = databaseConnector.getConnection();
        try {
            PreparedStatement p = conn.prepareStatement("select doi_tuong, linh_vuc, ky_du_lieu, don_vi_bao_cao, don_vi_nhan_bao_cao, data from dbo.data");
            ResultSet rs = p.executeQuery();
            while (rs.next()){
                String doiTuong = rs.getString("doi_tuong");
                String linhVuc = rs.getString("linh_vuc");
                String kyDuLieu = rs.getString("ky_du_lieu");
                String donViBaoCao = rs.getString("don_vi_bao_cao");
                String donViNhanBaoCao = rs.getString("don_vi_nhan_bao_cao");
                String data = rs.getString("data");
                dataList.add(new Data(doiTuong, linhVuc, kyDuLieu, donViBaoCao, donViNhanBaoCao, data));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            databaseConnector.closeConnection(conn);
        }
        return dataList;
    }

    @Override
    public int insertTable(Data data) {
        int result = 0;
        Connection conn = databaseConnector.getConnection();
        try {
            String sql = "Insert into dbo.data(doi_tuong, linh_vuc, ky_du_lieu, don_vi_bao_cao, don_vi_nhan_bao_cao, data)" +
                    "values(?, ?, ?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, data.getDoi_tuong());
            p.setString(2, data.getLinh_vuc());
            p.setString(3, data.getKy_du_lieu());
            p.setString(4, data.getDon_vi_bao_cao());
            p.setString(5, data.getDon_vi_nhan_bao_cao());
            p.setString(6, data.getData());
            result = p.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            databaseConnector.closeConnection(conn);
        }
        return result;
    }
}

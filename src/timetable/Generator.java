/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import DBconnetions.DBconnect;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import service.DBConnect;

public class Generator extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    String ID = null;
    ResultSet rs = null;

    String ids;

    int r;

    public String anum, pnum, dnum, snum, tnum;
    public int id1, id2, id3, id4, id5;
    
    view_lecturers view_lecturers;
    lecturer_add lecturer_add;
    lec_timetables lec_timetables;

    /**
     * Creates new form Generator
     */
    public Generator() {
        initComponents();

        //Parent.removeAll();
        //Parent.add(studentPanel);
        //Parent.repaint();
        //Parent.revalidate();
        con = DBconnect.connect();
        //loading table of locations
        LocationtableLoad();

        //load table of working hours
        tableload();

        loadId1();
        loadDataAcademic();
        loadCombo();
        loadId2();
        loadDataProgramme();
        loadId3();
        loadId4();
        loadId5();
        loadDataGroup();
        loadDataSubGroup();
        setTableSubGroup();
        setTableGroup();
        loadCombo1();
        loadCombo2();
        loadDataTag();

        Font font = new Font("Verdana", Font.BOLD, 14);

        jTable1.getTableHeader().setFont(font);
        ((DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(0);

        jTable2.getTableHeader().setFont(font);
        ((DefaultTableCellRenderer) jTable2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(0);

        jTable3.getTableHeader().setFont(font);
        ((DefaultTableCellRenderer) jTable3.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(0);

        jTable5.getTableHeader().setFont(font);
        ((DefaultTableCellRenderer) jTable5.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(0);

        jTable6.getTableHeader().setFont(font);
        ((DefaultTableCellRenderer) jTable6.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(0);

        jTable7.getTableHeader().setFont(font);
        ((DefaultTableCellRenderer) jTable7.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(0);

        jTable4.getTableHeader().setFont(font);
        ((DefaultTableCellRenderer) jTable4.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(0);
    }

    public void setColor(JPanel panel) {
        panel.setBackground(new Color(100, 0, 102));
    }

    public void resetColor(JPanel[] panel, JPanel[] indicators) {

        for (int i = 0; i < indicators.length; i++) {
            indicators[i].setOpaque(false);
        }

        for (int i = 0; i < panel.length; i++) {
            panel[i].setBackground(new Color(102, 0, 102));
        }

    }

    public void LocationtableLoad() {
        try {
            String query = "SELECT locationID,buildingName,room,capacity,roomType FROM location";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            locDetails.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void LocationEditTableLoad() {

        try {
            String query = "SELECT locationID,buildingName,room,capacity,roomType FROM location";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            locationInfo.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void clear() {
        buildName.setText("");
        room.setText("");
        capacity.setText("");
        rType.setSelectedItem("Select a Room Type");

        buildName1.setText("");
        room1.setText("");
        capacity1.setText("");
        rType1.setSelectedItem("Select a Room Type");

        buildName2.setText("");

    }

    //view table
    public void tableload() {

        try {

            //Retrieving data from the database
            String sql = "SELECT id,timetable_type,working_days,working_time FROM working_details";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            wds_third_table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        d_btn_10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ind_10 = new javax.swing.JPanel();
        d_btn_1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ind_1 = new javax.swing.JPanel();
        d_btn_2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ind_2 = new javax.swing.JPanel();
        d_btn_3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ind_3 = new javax.swing.JPanel();
        d_btn_4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ind_4 = new javax.swing.JPanel();
        d_btn_5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ind_5 = new javax.swing.JPanel();
        d_btn_8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        ind_8 = new javax.swing.JPanel();
        d_btn_6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        ind_6 = new javax.swing.JPanel();
        d_btn_7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        ind_7 = new javax.swing.JPanel();
        d_btn_9 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        ind_9 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        Parent = new javax.swing.JPanel();
        locationPanel = new javax.swing.JPanel();
        location_details = new javax.swing.JPanel();
        LocationMainBtnLabel = new javax.swing.JLabel();
        locationMainBtn = new javax.swing.JButton();
        LocationMainBtnImgLabel = new javax.swing.JLabel();
        group_lecturers = new javax.swing.JPanel();
        groupLecLabel = new javax.swing.JLabel();
        groupAndLecBtn = new javax.swing.JButton();
        groupLecLabelIcon = new javax.swing.JLabel();
        roomreservation = new javax.swing.JPanel();
        reservationLabel = new javax.swing.JLabel();
        reservationBtn = new javax.swing.JButton();
        reservationIcon = new javax.swing.JLabel();
        location_sessions = new javax.swing.JPanel();
        allo_and_session_label = new javax.swing.JLabel();
        alloAndSessionBtn = new javax.swing.JButton();
        allo_and_session_iconLabel = new javax.swing.JLabel();
        room_tagDets = new javax.swing.JPanel();
        roomAndTagLabel = new javax.swing.JLabel();
        groupAndTagBtn = new javax.swing.JButton();
        roomAndTagIcon = new javax.swing.JLabel();
        workingdaysPanel = new javax.swing.JPanel();
        parent_wds = new javax.swing.JPanel();
        wds_first = new javax.swing.JPanel();
        wds_f_add_pnl = new javax.swing.JPanel();
        wds_f_add_img = new javax.swing.JLabel();
        wds_first_add = new javax.swing.JButton();
        wds_f_view_pnl = new javax.swing.JPanel();
        wds_f_view_img = new javax.swing.JLabel();
        wds_first_view = new javax.swing.JButton();
        wds_second = new javax.swing.JPanel();
        wds_sec_title = new javax.swing.JLabel();
        wds_sec_pn = new javax.swing.JPanel();
        wds_sec_type_lbl = new javax.swing.JLabel();
        wds_sec_type = new javax.swing.JComboBox<>();
        wds_sec_no_lbl = new javax.swing.JLabel();
        wds_sec_ndays = new javax.swing.JComboBox<>();
        wds_sec_days_lbl = new javax.swing.JLabel();
        monday = new javax.swing.JCheckBox();
        tuesday = new javax.swing.JCheckBox();
        wednesday = new javax.swing.JCheckBox();
        thursday = new javax.swing.JCheckBox();
        friday = new javax.swing.JCheckBox();
        saturday = new javax.swing.JCheckBox();
        sunday = new javax.swing.JCheckBox();
        wds_sec_time_lbl = new javax.swing.JLabel();
        wds_sec_hrs_lbl = new javax.swing.JLabel();
        wds_sec_hrs = new javax.swing.JTextField();
        wds_sec_mins_lbl = new javax.swing.JLabel();
        wds_sec_mins = new javax.swing.JTextField();
        wds_sec_slot_lbl = new javax.swing.JLabel();
        wds_sec_slot = new javax.swing.JComboBox<>();
        wds_second_add_btn = new javax.swing.JButton();
        wds_second_view_btn = new javax.swing.JButton();
        wds_second_back_btn = new javax.swing.JButton();
        wds_third_viewdetails = new javax.swing.JPanel();
        wds_third_title = new javax.swing.JLabel();
        wds_third_scroll = new javax.swing.JScrollPane();
        wds_third_table = new javax.swing.JTable();
        wds_third_backbtn = new javax.swing.JButton();
        wds_third_deletebtn = new javax.swing.JButton();
        wds_third_editbtn = new javax.swing.JButton();
        wds_fourth_update = new javax.swing.JPanel();
        wds_fourth_title = new javax.swing.JLabel();
        wds_fourth_pn = new javax.swing.JPanel();
        wds_fourth_tid_lbl = new javax.swing.JLabel();
        test = new javax.swing.JLabel();
        wds_fourth_type_lbl = new javax.swing.JLabel();
        wds_fourth_type = new javax.swing.JComboBox<>();
        wds_fourth_no_lbl = new javax.swing.JLabel();
        wds_fourth_ndays = new javax.swing.JComboBox<>();
        wds_fourth_days_lbl = new javax.swing.JLabel();
        up_monday = new javax.swing.JCheckBox();
        up_tuesday = new javax.swing.JCheckBox();
        up_wednesday = new javax.swing.JCheckBox();
        up_thursday = new javax.swing.JCheckBox();
        up_friday = new javax.swing.JCheckBox();
        up_saturday = new javax.swing.JCheckBox();
        up_sunday = new javax.swing.JCheckBox();
        wds_fourth_time_lbl = new javax.swing.JLabel();
        wds_fourth_hrs_lbl = new javax.swing.JLabel();
        wds_fourth_hrs = new javax.swing.JTextField();
        wds_fourth_mins_lbl = new javax.swing.JLabel();
        wds_fourth_mins = new javax.swing.JTextField();
        wds_fourth_slot_lbl = new javax.swing.JLabel();
        wds_fourth_slot = new javax.swing.JComboBox<>();
        wds_fourth_updatebtn = new javax.swing.JButton();
        wds_fourth_backbtn = new javax.swing.JButton();
        timetablesPanel = new javax.swing.JPanel();
        statsticsPanel = new javax.swing.JPanel();
        data_visualization = new javax.swing.JPanel();
        visualizationTitle = new javax.swing.JLabel();
        statisticBtn = new javax.swing.JButton();
        statisticImage = new javax.swing.JLabel();
        locationDetails = new javax.swing.JPanel();
        locationDet_panel = new javax.swing.JPanel();
        locationDet_title = new javax.swing.JLabel();
        buildingNameLabel = new javax.swing.JLabel();
        buildName = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        locDetailScrolPane = new javax.swing.JScrollPane();
        locDetails = new javax.swing.JTable();
        Delete = new javax.swing.JButton();
        add = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        addLocation = new javax.swing.JPanel();
        locationAdd_panel = new javax.swing.JPanel();
        addBuilding = new javax.swing.JButton();
        addLoc = new javax.swing.JButton();
        AddLocationDetTitle = new javax.swing.JLabel();
        addBuildingNameLabel = new javax.swing.JLabel();
        roomLabel = new javax.swing.JLabel();
        capacityLabel = new javax.swing.JLabel();
        roomTypeLabel = new javax.swing.JLabel();
        room = new javax.swing.JTextField();
        buildName1 = new javax.swing.JTextField();
        capacity = new javax.swing.JTextField();
        rType = new javax.swing.JComboBox<>();
        addBack = new javax.swing.JButton();
        editLocation = new javax.swing.JPanel();
        locationEdit_panel = new javax.swing.JPanel();
        searchBuildInEditLabel = new javax.swing.JLabel();
        editLoc = new javax.swing.JButton();
        roomTypeEditLabel = new javax.swing.JLabel();
        editLocationDetTitle = new javax.swing.JLabel();
        delBuild = new javax.swing.JButton();
        roomEditLabel = new javax.swing.JLabel();
        EditLocationDetailScriollPane = new javax.swing.JScrollPane();
        locationInfo = new javax.swing.JTable();
        room1 = new javax.swing.JTextField();
        sName = new javax.swing.JTextField();
        buildName2 = new javax.swing.JTextField();
        capacity1 = new javax.swing.JTextField();
        editBack = new javax.swing.JButton();
        capacityEditLabel = new javax.swing.JLabel();
        editLocSubTitle = new javax.swing.JLabel();
        rType1 = new javax.swing.JComboBox<>();
        EditBuildLabel = new javax.swing.JLabel();
        searchBuild = new javax.swing.JButton();
        dataVisualization = new javax.swing.JPanel();
        statistical_panel = new javax.swing.JPanel();
        statisticTitel = new javax.swing.JLabel();
        Visualization_Panel = new javax.swing.JPanel();
        studentStatisticData = new javax.swing.JButton();
        panelChart = new javax.swing.JPanel();
        lecturersStatisticData = new javax.swing.JButton();
        subjectsStatisticData = new javax.swing.JButton();
        lecturersChrt = new javax.swing.JPanel();
        subjectChart = new javax.swing.JPanel();
        subjects = new javax.swing.JPanel();
        jPanel27_27 = new javax.swing.JPanel();
        subject_add = new javax.swing.JButton();
        jLabel79_79 = new javax.swing.JLabel();
        jLabel80_80 = new javax.swing.JLabel();
        jLabel29_29 = new javax.swing.JLabel();
        jPanel28_28 = new javax.swing.JPanel();
        jLabel81_81 = new javax.swing.JLabel();
        jPanel29_29 = new javax.swing.JPanel();
        subject_details = new javax.swing.JButton();
        jLabel82_82 = new javax.swing.JLabel();
        jLabel28_28 = new javax.swing.JLabel();
        subjects_add = new javax.swing.JPanel();
        add_subs = new javax.swing.JButton();
        jPanel30_30 = new javax.swing.JPanel();
        jLabel90_90 = new javax.swing.JLabel();
        jButton17_17 = new javax.swing.JButton();
        jPanel36_36 = new javax.swing.JPanel();
        jLabel92_92 = new javax.swing.JLabel();
        sa = new javax.swing.JTextField();
        jLabel30_30 = new javax.swing.JLabel();
        sa1 = new javax.swing.JTextField();
        jLabel91_91 = new javax.swing.JLabel();
        sa2 = new javax.swing.JComboBox<>();
        jLabel94_94 = new javax.swing.JLabel();
        sa3 = new javax.swing.JComboBox<>();
        jLabel96_96 = new javax.swing.JLabel();
        sa4 = new javax.swing.JComboBox<>();
        jLabel93_93 = new javax.swing.JLabel();
        sa5 = new javax.swing.JComboBox<>();
        jLabel95_95 = new javax.swing.JLabel();
        sa6 = new javax.swing.JComboBox<>();
        jLabel97_97 = new javax.swing.JLabel();
        sa7 = new javax.swing.JComboBox<>();
        subject_detail = new javax.swing.JPanel();
        subject_detail1 = new javax.swing.JPanel();
        jLabel98_98 = new javax.swing.JLabel();
        jLabel99_99 = new javax.swing.JLabel();
        jLabel100_100 = new javax.swing.JLabel();
        jLabel101_101 = new javax.swing.JLabel();
        jLabel102_102 = new javax.swing.JLabel();
        jLabel103_103 = new javax.swing.JLabel();
        jLabel104_104 = new javax.swing.JLabel();
        jLabel105_105 = new javax.swing.JLabel();
        jPanel31_31 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        edit_sub = new javax.swing.JButton();
        delete_sub = new javax.swing.JButton();
        jButton20_20 = new javax.swing.JButton();
        jPanel15_15 = new javax.swing.JPanel();
        jLabel115_115 = new javax.swing.JLabel();
        delete_subjectdetail = new javax.swing.JButton();
        jPanel37_37 = new javax.swing.JPanel();
        jLabel107_107 = new javax.swing.JLabel();
        sd = new javax.swing.JTextField();
        jLabel108_108 = new javax.swing.JLabel();
        sd1 = new javax.swing.JTextField();
        jLabel109_109 = new javax.swing.JLabel();
        sd2 = new javax.swing.JComboBox<>();
        jLabel110_110 = new javax.swing.JLabel();
        sd3 = new javax.swing.JComboBox<>();
        jLabel111_111 = new javax.swing.JLabel();
        jLabel113_113 = new javax.swing.JLabel();
        sd4 = new javax.swing.JComboBox<>();
        sd5 = new javax.swing.JComboBox<>();
        jLabel112_112 = new javax.swing.JLabel();
        sd6 = new javax.swing.JComboBox<>();
        jLabel114_114 = new javax.swing.JLabel();
        sd7 = new javax.swing.JComboBox<>();
        view_sub = new javax.swing.JButton();
        jScrollPane4_4 = new javax.swing.JScrollPane();
        subjectTable = new javax.swing.JTable();
        subject_edit = new javax.swing.JPanel();
        update_sub = new javax.swing.JButton();
        jPanel32_32 = new javax.swing.JPanel();
        jLabel124_124 = new javax.swing.JLabel();
        jPanel38_38 = new javax.swing.JPanel();
        jLabel116_116 = new javax.swing.JLabel();
        se = new javax.swing.JTextField();
        jLabel117_117 = new javax.swing.JLabel();
        se1 = new javax.swing.JTextField();
        jLabel118_118 = new javax.swing.JLabel();
        se2 = new javax.swing.JComboBox<>();
        jLabel119_119 = new javax.swing.JLabel();
        se3 = new javax.swing.JComboBox<>();
        jLabel120_120 = new javax.swing.JLabel();
        se4 = new javax.swing.JComboBox<>();
        jLabel121_121 = new javax.swing.JLabel();
        se5 = new javax.swing.JComboBox<>();
        jLabel122_122 = new javax.swing.JLabel();
        se6 = new javax.swing.JComboBox<>();
        jLabel123_123 = new javax.swing.JLabel();
        se7 = new javax.swing.JComboBox<>();
        jButton23_23 = new javax.swing.JButton();
        studentPanel = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        tagsPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel35 = new javax.swing.JPanel();
        jLabel105 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        academicYear = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        addAcademicYear = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel73 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        editAcademicYear = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        programme = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        addProgramme = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        editProgramme = new javax.swing.JPanel();
        jButton18 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel55 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jButton13 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        groupNumbers = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        addGroupNumbers = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField7 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        addTags = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        editGroupNumbers = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jComboBox8 = new javax.swing.JComboBox<>();
        jTextField10 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        subGroupNumbers = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        addSubGroupNumbers = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jButton22 = new javax.swing.JButton();
        jComboBox6 = new javax.swing.JComboBox<>();
        jTextField12 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        editSubGroupNumbers = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        jComboBox7 = new javax.swing.JComboBox<>();
        jTextField13 = new javax.swing.JTextField();
        jButton24 = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        editTag = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        sessionsPanel = new javax.swing.JPanel();
        notAvailableTimes = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jPanel39 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jPanel41 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        jPanel42 = new javax.swing.JPanel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jButton27 = new javax.swing.JButton();
        notAvailable_lecturers = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        notAvailable_session = new javax.swing.JPanel();
        settingsPanel = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(69, 2, 69));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Dashboard");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 280, 20));

        d_btn_10.setBackground(new java.awt.Color(102, 0, 102));
        d_btn_10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d_btn_10MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Settings");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-settings-50 (1).png"))); // NOI18N

        ind_10.setOpaque(false);
        ind_10.setPreferredSize(new java.awt.Dimension(90, 60));

        javax.swing.GroupLayout ind_10Layout = new javax.swing.GroupLayout(ind_10);
        ind_10.setLayout(ind_10Layout);
        ind_10Layout.setHorizontalGroup(
            ind_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        ind_10Layout.setVerticalGroup(
            ind_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout d_btn_10Layout = new javax.swing.GroupLayout(d_btn_10);
        d_btn_10.setLayout(d_btn_10Layout);
        d_btn_10Layout.setHorizontalGroup(
            d_btn_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_btn_10Layout.createSequentialGroup()
                .addComponent(ind_10, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        d_btn_10Layout.setVerticalGroup(
            d_btn_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_btn_10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(d_btn_10Layout.createSequentialGroup()
                .addComponent(ind_10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(d_btn_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 890, 330, 60));

        d_btn_1.setBackground(new java.awt.Color(102, 0, 102));
        d_btn_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d_btn_1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                d_btn_1MousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Symbol", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Student");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-student-male-50 (3).png"))); // NOI18N

        ind_1.setBackground(new java.awt.Color(255, 255, 255));
        ind_1.setOpaque(false);
        ind_1.setPreferredSize(new java.awt.Dimension(90, 60));

        javax.swing.GroupLayout ind_1Layout = new javax.swing.GroupLayout(ind_1);
        ind_1.setLayout(ind_1Layout);
        ind_1Layout.setHorizontalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        ind_1Layout.setVerticalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout d_btn_1Layout = new javax.swing.GroupLayout(d_btn_1);
        d_btn_1.setLayout(d_btn_1Layout);
        d_btn_1Layout.setHorizontalGroup(
            d_btn_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_btn_1Layout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        d_btn_1Layout.setVerticalGroup(
            d_btn_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d_btn_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(d_btn_1Layout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(d_btn_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 330, 60));

        d_btn_2.setBackground(new java.awt.Color(102, 0, 102));
        d_btn_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d_btn_2MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Symbol", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Lecturers");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-lecturer-50 (2).png"))); // NOI18N

        ind_2.setBackground(new java.awt.Color(255, 255, 255));
        ind_2.setOpaque(false);
        ind_2.setPreferredSize(new java.awt.Dimension(90, 60));

        javax.swing.GroupLayout ind_2Layout = new javax.swing.GroupLayout(ind_2);
        ind_2.setLayout(ind_2Layout);
        ind_2Layout.setHorizontalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        ind_2Layout.setVerticalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout d_btn_2Layout = new javax.swing.GroupLayout(d_btn_2);
        d_btn_2.setLayout(d_btn_2Layout);
        d_btn_2Layout.setHorizontalGroup(
            d_btn_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_btn_2Layout.createSequentialGroup()
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        d_btn_2Layout.setVerticalGroup(
            d_btn_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d_btn_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d_btn_2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(d_btn_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 330, 60));

        d_btn_3.setBackground(new java.awt.Color(102, 0, 102));
        d_btn_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d_btn_3MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Symbol", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tags");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-check-document-50 (1).png"))); // NOI18N

        ind_3.setOpaque(false);
        ind_3.setPreferredSize(new java.awt.Dimension(90, 60));

        javax.swing.GroupLayout ind_3Layout = new javax.swing.GroupLayout(ind_3);
        ind_3.setLayout(ind_3Layout);
        ind_3Layout.setHorizontalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        ind_3Layout.setVerticalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout d_btn_3Layout = new javax.swing.GroupLayout(d_btn_3);
        d_btn_3.setLayout(d_btn_3Layout);
        d_btn_3Layout.setHorizontalGroup(
            d_btn_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_btn_3Layout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        d_btn_3Layout.setVerticalGroup(
            d_btn_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_btn_3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(d_btn_3Layout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(d_btn_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 330, 60));

        d_btn_4.setBackground(new java.awt.Color(102, 0, 102));
        d_btn_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d_btn_4MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Symbol", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Location");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-taxi-location-50 (2).png"))); // NOI18N

        ind_4.setOpaque(false);
        ind_4.setPreferredSize(new java.awt.Dimension(90, 60));

        javax.swing.GroupLayout ind_4Layout = new javax.swing.GroupLayout(ind_4);
        ind_4.setLayout(ind_4Layout);
        ind_4Layout.setHorizontalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        ind_4Layout.setVerticalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout d_btn_4Layout = new javax.swing.GroupLayout(d_btn_4);
        d_btn_4.setLayout(d_btn_4Layout);
        d_btn_4Layout.setHorizontalGroup(
            d_btn_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_btn_4Layout.createSequentialGroup()
                .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel12)
                .addGap(54, 54, 54)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        d_btn_4Layout.setVerticalGroup(
            d_btn_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_btn_4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(d_btn_4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(d_btn_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 330, 60));

        d_btn_5.setBackground(new java.awt.Color(102, 0, 102));
        d_btn_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d_btn_5MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI Symbol", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Working days");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-clock-50 (1).png"))); // NOI18N

        ind_5.setOpaque(false);
        ind_5.setPreferredSize(new java.awt.Dimension(90, 60));

        javax.swing.GroupLayout ind_5Layout = new javax.swing.GroupLayout(ind_5);
        ind_5.setLayout(ind_5Layout);
        ind_5Layout.setHorizontalGroup(
            ind_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        ind_5Layout.setVerticalGroup(
            ind_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout d_btn_5Layout = new javax.swing.GroupLayout(d_btn_5);
        d_btn_5.setLayout(d_btn_5Layout);
        d_btn_5Layout.setHorizontalGroup(
            d_btn_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_btn_5Layout.createSequentialGroup()
                .addComponent(ind_5, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel13)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        d_btn_5Layout.setVerticalGroup(
            d_btn_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_btn_5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(d_btn_5Layout.createSequentialGroup()
                .addComponent(ind_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(d_btn_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 330, 60));

        d_btn_8.setBackground(new java.awt.Color(102, 0, 102));
        d_btn_8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d_btn_8MouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI Symbol", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Subjects");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-book-50 (1).png"))); // NOI18N

        ind_8.setOpaque(false);
        ind_8.setPreferredSize(new java.awt.Dimension(90, 60));

        javax.swing.GroupLayout ind_8Layout = new javax.swing.GroupLayout(ind_8);
        ind_8.setLayout(ind_8Layout);
        ind_8Layout.setHorizontalGroup(
            ind_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        ind_8Layout.setVerticalGroup(
            ind_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout d_btn_8Layout = new javax.swing.GroupLayout(d_btn_8);
        d_btn_8.setLayout(d_btn_8Layout);
        d_btn_8Layout.setHorizontalGroup(
            d_btn_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_btn_8Layout.createSequentialGroup()
                .addComponent(ind_8, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel15)
                .addContainerGap(120, Short.MAX_VALUE))
        );
        d_btn_8Layout.setVerticalGroup(
            d_btn_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_btn_8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d_btn_8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ind_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(d_btn_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 730, 330, 60));

        d_btn_6.setBackground(new java.awt.Color(102, 0, 102));
        d_btn_6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d_btn_6MouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI Symbol", 0, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Sessions");

        jLabel20.setBackground(new java.awt.Color(68, 68, 69));
        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-task-50 (1).png"))); // NOI18N

        ind_6.setOpaque(false);
        ind_6.setPreferredSize(new java.awt.Dimension(90, 60));

        javax.swing.GroupLayout ind_6Layout = new javax.swing.GroupLayout(ind_6);
        ind_6.setLayout(ind_6Layout);
        ind_6Layout.setHorizontalGroup(
            ind_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        ind_6Layout.setVerticalGroup(
            ind_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout d_btn_6Layout = new javax.swing.GroupLayout(d_btn_6);
        d_btn_6.setLayout(d_btn_6Layout);
        d_btn_6Layout.setHorizontalGroup(
            d_btn_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_btn_6Layout.createSequentialGroup()
                .addComponent(ind_6, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel20)
                .addGap(47, 47, 47)
                .addComponent(jLabel19)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        d_btn_6Layout.setVerticalGroup(
            d_btn_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_btn_6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(d_btn_6Layout.createSequentialGroup()
                .addComponent(ind_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(d_btn_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 330, 60));

        d_btn_7.setBackground(new java.awt.Color(102, 0, 102));
        d_btn_7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d_btn_7MouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI Symbol", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Timetables");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-calendar-50 (1).png"))); // NOI18N

        ind_7.setOpaque(false);
        ind_7.setPreferredSize(new java.awt.Dimension(90, 60));

        javax.swing.GroupLayout ind_7Layout = new javax.swing.GroupLayout(ind_7);
        ind_7.setLayout(ind_7Layout);
        ind_7Layout.setHorizontalGroup(
            ind_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        ind_7Layout.setVerticalGroup(
            ind_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout d_btn_7Layout = new javax.swing.GroupLayout(d_btn_7);
        d_btn_7.setLayout(d_btn_7Layout);
        d_btn_7Layout.setHorizontalGroup(
            d_btn_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_btn_7Layout.createSequentialGroup()
                .addComponent(ind_7, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel17)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        d_btn_7Layout.setVerticalGroup(
            d_btn_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_btn_7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(d_btn_7Layout.createSequentialGroup()
                .addComponent(ind_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(d_btn_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 330, 60));

        d_btn_9.setBackground(new java.awt.Color(102, 0, 102));
        d_btn_9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d_btn_9MouseClicked(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Segoe UI Symbol", 0, 20)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Statistics");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-graph-50 (1).png"))); // NOI18N

        ind_9.setOpaque(false);
        ind_9.setPreferredSize(new java.awt.Dimension(90, 60));

        javax.swing.GroupLayout ind_9Layout = new javax.swing.GroupLayout(ind_9);
        ind_9.setLayout(ind_9Layout);
        ind_9Layout.setHorizontalGroup(
            ind_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        ind_9Layout.setVerticalGroup(
            ind_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout d_btn_9Layout = new javax.swing.GroupLayout(d_btn_9);
        d_btn_9.setLayout(d_btn_9Layout);
        d_btn_9Layout.setHorizontalGroup(
            d_btn_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_btn_9Layout.createSequentialGroup()
                .addComponent(ind_9, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel35)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        d_btn_9Layout.setVerticalGroup(
            d_btn_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_btn_9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(d_btn_9Layout.createSequentialGroup()
                .addComponent(ind_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(d_btn_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 810, 330, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 324, 1010));

        jPanel3.setBackground(new java.awt.Color(69, 2, 69));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Timetable Generator");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, -1, -1));

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-close-window-50 (2).png"))); // NOI18N
        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel42MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 30, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 1600, 120));

        Parent.setLayout(new java.awt.CardLayout());

        locationPanel.setBackground(new java.awt.Color(0, 204, 204));

        location_details.setBackground(new java.awt.Color(0, 153, 204));
        location_details.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        LocationMainBtnLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LocationMainBtnLabel.setText("Location Details");

        locationMainBtn.setBackground(new java.awt.Color(0, 0, 0));
        locationMainBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        locationMainBtn.setText(">>>>");
        locationMainBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationMainBtnActionPerformed(evt);
            }
        });

        LocationMainBtnImgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/location.png"))); // NOI18N

        javax.swing.GroupLayout location_detailsLayout = new javax.swing.GroupLayout(location_details);
        location_details.setLayout(location_detailsLayout);
        location_detailsLayout.setHorizontalGroup(
            location_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(location_detailsLayout.createSequentialGroup()
                .addGroup(location_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(location_detailsLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(LocationMainBtnImgLabel))
                    .addGroup(location_detailsLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(LocationMainBtnLabel)))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, location_detailsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(locationMainBtn)
                .addGap(128, 128, 128))
        );
        location_detailsLayout.setVerticalGroup(
            location_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, location_detailsLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(LocationMainBtnImgLabel)
                .addGap(28, 28, 28)
                .addComponent(LocationMainBtnLabel)
                .addGap(18, 18, 18)
                .addComponent(locationMainBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        group_lecturers.setBackground(new java.awt.Color(0, 153, 204));
        group_lecturers.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        groupLecLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        groupLecLabel.setText("Groups & Lecturers");

        groupAndLecBtn.setBackground(new java.awt.Color(0, 0, 0));
        groupAndLecBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        groupAndLecBtn.setText(">>>>");
        groupAndLecBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupAndLecBtnActionPerformed(evt);
            }
        });

        groupLecLabelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/groups&Lec.png"))); // NOI18N

        javax.swing.GroupLayout group_lecturersLayout = new javax.swing.GroupLayout(group_lecturers);
        group_lecturers.setLayout(group_lecturersLayout);
        group_lecturersLayout.setHorizontalGroup(
            group_lecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(group_lecturersLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(groupLecLabel)
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, group_lecturersLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(groupAndLecBtn)
                .addGap(119, 119, 119))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, group_lecturersLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(groupLecLabelIcon)
                .addGap(58, 58, 58))
        );
        group_lecturersLayout.setVerticalGroup(
            group_lecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, group_lecturersLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(groupLecLabelIcon)
                .addGap(42, 42, 42)
                .addComponent(groupLecLabel)
                .addGap(18, 18, 18)
                .addComponent(groupAndLecBtn)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        roomreservation.setBackground(new java.awt.Color(0, 153, 204));
        roomreservation.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        reservationLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        reservationLabel.setText("Room Reservation");

        reservationBtn.setBackground(new java.awt.Color(0, 0, 0));
        reservationBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reservationBtn.setText(">>>>");
        reservationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservationBtnActionPerformed(evt);
            }
        });

        reservationIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reserve.jpg"))); // NOI18N

        javax.swing.GroupLayout roomreservationLayout = new javax.swing.GroupLayout(roomreservation);
        roomreservation.setLayout(roomreservationLayout);
        roomreservationLayout.setHorizontalGroup(
            roomreservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomreservationLayout.createSequentialGroup()
                .addGroup(roomreservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomreservationLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(reservationIcon))
                    .addGroup(roomreservationLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(reservationLabel))
                    .addGroup(roomreservationLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(reservationBtn)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        roomreservationLayout.setVerticalGroup(
            roomreservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roomreservationLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(reservationIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(reservationLabel)
                .addGap(18, 18, 18)
                .addComponent(reservationBtn)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        location_sessions.setBackground(new java.awt.Color(0, 153, 204));
        location_sessions.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        allo_and_session_label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        allo_and_session_label.setText("Location Allocation for Sessions");

        alloAndSessionBtn.setBackground(new java.awt.Color(0, 0, 0));
        alloAndSessionBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        alloAndSessionBtn.setText(">>>>");
        alloAndSessionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alloAndSessionBtnActionPerformed(evt);
            }
        });

        allo_and_session_iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/session.png"))); // NOI18N

        javax.swing.GroupLayout location_sessionsLayout = new javax.swing.GroupLayout(location_sessions);
        location_sessions.setLayout(location_sessionsLayout);
        location_sessionsLayout.setHorizontalGroup(
            location_sessionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(location_sessionsLayout.createSequentialGroup()
                .addGroup(location_sessionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(location_sessionsLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(alloAndSessionBtn))
                    .addGroup(location_sessionsLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(allo_and_session_label))
                    .addGroup(location_sessionsLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(allo_and_session_iconLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        location_sessionsLayout.setVerticalGroup(
            location_sessionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, location_sessionsLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(allo_and_session_iconLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(allo_and_session_label)
                .addGap(18, 18, 18)
                .addComponent(alloAndSessionBtn)
                .addGap(21, 21, 21))
        );

        room_tagDets.setBackground(new java.awt.Color(0, 153, 204));
        room_tagDets.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        roomAndTagLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        roomAndTagLabel.setText("Room & Tag Details");

        groupAndTagBtn.setBackground(new java.awt.Color(0, 0, 0));
        groupAndTagBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        groupAndTagBtn.setText(">>>>");
        groupAndTagBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupAndTagBtnActionPerformed(evt);
            }
        });

        roomAndTagIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tag.png"))); // NOI18N

        javax.swing.GroupLayout room_tagDetsLayout = new javax.swing.GroupLayout(room_tagDets);
        room_tagDets.setLayout(room_tagDetsLayout);
        room_tagDetsLayout.setHorizontalGroup(
            room_tagDetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, room_tagDetsLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(roomAndTagIcon)
                .addGap(63, 63, 63))
            .addGroup(room_tagDetsLayout.createSequentialGroup()
                .addGroup(room_tagDetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(room_tagDetsLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(roomAndTagLabel))
                    .addGroup(room_tagDetsLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(groupAndTagBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        room_tagDetsLayout.setVerticalGroup(
            room_tagDetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, room_tagDetsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(roomAndTagIcon)
                .addGap(18, 18, 18)
                .addComponent(roomAndTagLabel)
                .addGap(18, 18, 18)
                .addComponent(groupAndTagBtn)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout locationPanelLayout = new javax.swing.GroupLayout(locationPanel);
        locationPanel.setLayout(locationPanelLayout);
        locationPanelLayout.setHorizontalGroup(
            locationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locationPanelLayout.createSequentialGroup()
                .addGroup(locationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(locationPanelLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(location_details, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(location_sessions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(group_lecturers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(locationPanelLayout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(roomreservation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addComponent(room_tagDets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(3157, Short.MAX_VALUE))
        );
        locationPanelLayout.setVerticalGroup(
            locationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locationPanelLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(locationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(location_sessions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(group_lecturers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(location_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(locationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roomreservation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room_tagDets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        Parent.add(locationPanel, "locationPanel");

        workingdaysPanel.setBackground(new java.awt.Color(102, 52, 109));
        workingdaysPanel.setToolTipText("");

        parent_wds.setBackground(new java.awt.Color(255, 255, 255));
        parent_wds.setLayout(new java.awt.CardLayout());

        wds_first.setBackground(new java.awt.Color(102, 52, 109));

        wds_f_add_pnl.setBackground(new java.awt.Color(255, 255, 255));

        wds_f_add_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calendar (3).png"))); // NOI18N

        wds_first_add.setBackground(new java.awt.Color(255, 255, 255));
        wds_first_add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        wds_first_add.setText("ADD WORKING DAYS");
        wds_first_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wds_first_addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout wds_f_add_pnlLayout = new javax.swing.GroupLayout(wds_f_add_pnl);
        wds_f_add_pnl.setLayout(wds_f_add_pnlLayout);
        wds_f_add_pnlLayout.setHorizontalGroup(
            wds_f_add_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wds_f_add_pnlLayout.createSequentialGroup()
                .addGroup(wds_f_add_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(wds_f_add_pnlLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(wds_f_add_img))
                    .addGroup(wds_f_add_pnlLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(wds_first_add)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        wds_f_add_pnlLayout.setVerticalGroup(
            wds_f_add_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wds_f_add_pnlLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(wds_f_add_img, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(wds_first_add, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        wds_f_view_pnl.setBackground(new java.awt.Color(255, 255, 255));

        wds_f_view_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calendar (3).png"))); // NOI18N

        wds_first_view.setBackground(new java.awt.Color(255, 255, 255));
        wds_first_view.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        wds_first_view.setText("VIEW WORKING DAYS");
        wds_first_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wds_first_viewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout wds_f_view_pnlLayout = new javax.swing.GroupLayout(wds_f_view_pnl);
        wds_f_view_pnl.setLayout(wds_f_view_pnlLayout);
        wds_f_view_pnlLayout.setHorizontalGroup(
            wds_f_view_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wds_f_view_pnlLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(wds_first_view)
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wds_f_view_pnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(wds_f_view_img, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        wds_f_view_pnlLayout.setVerticalGroup(
            wds_f_view_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wds_f_view_pnlLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(wds_f_view_img, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addComponent(wds_first_view, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout wds_firstLayout = new javax.swing.GroupLayout(wds_first);
        wds_first.setLayout(wds_firstLayout);
        wds_firstLayout.setHorizontalGroup(
            wds_firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wds_firstLayout.createSequentialGroup()
                .addGap(349, 349, 349)
                .addComponent(wds_f_add_pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(244, 244, 244)
                .addComponent(wds_f_view_pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(358, Short.MAX_VALUE))
        );
        wds_firstLayout.setVerticalGroup(
            wds_firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wds_firstLayout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addGroup(wds_firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(wds_f_view_pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(wds_f_add_pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(456, Short.MAX_VALUE))
        );

        parent_wds.add(wds_first, "card2");

        wds_second.setBackground(new java.awt.Color(102, 52, 109));

        wds_sec_title.setBackground(new java.awt.Color(255, 255, 255));
        wds_sec_title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        wds_sec_title.setForeground(new java.awt.Color(255, 255, 255));
        wds_sec_title.setText("ADD WORKING DAYS AND HOURS");

        wds_sec_pn.setBackground(new java.awt.Color(137, 14, 137));
        wds_sec_pn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        wds_sec_type_lbl.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_sec_type_lbl.setForeground(new java.awt.Color(255, 255, 255));
        wds_sec_type_lbl.setText("Timetable Type");

        wds_sec_type.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_sec_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Weekend", "Weekdays" }));

        wds_sec_no_lbl.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_sec_no_lbl.setForeground(new java.awt.Color(255, 255, 255));
        wds_sec_no_lbl.setText("Number of Working Days (per week)");

        wds_sec_ndays.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_sec_ndays.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));

        wds_sec_days_lbl.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_sec_days_lbl.setForeground(new java.awt.Color(255, 255, 255));
        wds_sec_days_lbl.setText("Working Days");

        monday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        monday.setText("Monday");

        tuesday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        tuesday.setText("Tuesday");
        tuesday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuesdayActionPerformed(evt);
            }
        });

        wednesday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wednesday.setText("Wednesday");

        thursday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        thursday.setText("Thursday");

        friday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        friday.setText("Friday");

        saturday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        saturday.setText("Saturday");

        sunday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        sunday.setText("Sunday");
        sunday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sundayActionPerformed(evt);
            }
        });

        wds_sec_time_lbl.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_sec_time_lbl.setForeground(new java.awt.Color(255, 255, 255));
        wds_sec_time_lbl.setText("Working Time (per day)");

        wds_sec_hrs_lbl.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_sec_hrs_lbl.setForeground(new java.awt.Color(255, 255, 255));
        wds_sec_hrs_lbl.setText("hours");

        wds_sec_hrs.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        wds_sec_mins_lbl.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_sec_mins_lbl.setForeground(new java.awt.Color(255, 255, 255));
        wds_sec_mins_lbl.setText("minutes");

        wds_sec_mins.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        wds_sec_slot_lbl.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_sec_slot_lbl.setForeground(new java.awt.Color(255, 255, 255));
        wds_sec_slot_lbl.setText("Time Slot");

        wds_sec_slot.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_sec_slot.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 hour", "30 minutes" }));

        wds_second_add_btn.setBackground(new java.awt.Color(102, 102, 102));
        wds_second_add_btn.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        wds_second_add_btn.setText("ADD");
        wds_second_add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wds_second_add_btnActionPerformed(evt);
            }
        });

        wds_second_view_btn.setBackground(new java.awt.Color(102, 102, 102));
        wds_second_view_btn.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        wds_second_view_btn.setText("VIEW DETAILS");
        wds_second_view_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wds_second_view_btnActionPerformed(evt);
            }
        });

        wds_second_back_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        wds_second_back_btn.setText("back");
        wds_second_back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wds_second_back_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout wds_sec_pnLayout = new javax.swing.GroupLayout(wds_sec_pn);
        wds_sec_pn.setLayout(wds_sec_pnLayout);
        wds_sec_pnLayout.setHorizontalGroup(
            wds_sec_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wds_sec_pnLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(wds_sec_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(wds_sec_pnLayout.createSequentialGroup()
                        .addComponent(wds_sec_time_lbl)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(wds_sec_pnLayout.createSequentialGroup()
                        .addGroup(wds_sec_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(wds_sec_pnLayout.createSequentialGroup()
                                .addComponent(wds_sec_type_lbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(wds_sec_type, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wds_sec_pnLayout.createSequentialGroup()
                                .addGroup(wds_sec_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(wds_sec_no_lbl)
                                    .addComponent(wds_sec_days_lbl)
                                    .addComponent(wds_sec_slot_lbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                .addGroup(wds_sec_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(wds_sec_slot, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(wds_sec_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(wds_sec_pnLayout.createSequentialGroup()
                                            .addGroup(wds_sec_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(tuesday, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                                .addComponent(monday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(40, 40, 40)
                                            .addGroup(wds_sec_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(sunday, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(saturday, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(wds_sec_ndays, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(wds_sec_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(friday, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(thursday, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(wednesday, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(wds_sec_pnLayout.createSequentialGroup()
                                            .addComponent(wds_sec_hrs_lbl)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(wds_sec_hrs, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(36, 36, 36)
                                            .addComponent(wds_sec_mins_lbl)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(wds_sec_mins))))))
                        .addGap(111, 111, 111))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wds_sec_pnLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(wds_second_add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addComponent(wds_second_view_btn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wds_sec_pnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(wds_second_back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        wds_sec_pnLayout.setVerticalGroup(
            wds_sec_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wds_sec_pnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(wds_sec_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wds_sec_type_lbl)
                    .addComponent(wds_sec_type, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(wds_sec_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wds_sec_no_lbl)
                    .addComponent(wds_sec_ndays, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(wds_sec_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wds_sec_days_lbl)
                    .addComponent(monday)
                    .addComponent(saturday))
                .addGap(18, 18, 18)
                .addGroup(wds_sec_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tuesday)
                    .addComponent(sunday))
                .addGap(18, 18, 18)
                .addComponent(wednesday)
                .addGap(18, 18, 18)
                .addComponent(thursday)
                .addGap(18, 18, 18)
                .addComponent(friday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(wds_sec_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wds_sec_pnLayout.createSequentialGroup()
                        .addGroup(wds_sec_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(wds_sec_time_lbl)
                            .addComponent(wds_sec_hrs_lbl)
                            .addComponent(wds_sec_hrs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wds_sec_mins_lbl)
                            .addComponent(wds_sec_mins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(wds_sec_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(wds_sec_slot_lbl)
                            .addComponent(wds_sec_slot, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(116, 116, 116)
                        .addComponent(wds_second_back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wds_sec_pnLayout.createSequentialGroup()
                        .addGroup(wds_sec_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(wds_second_view_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wds_second_add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81))))
        );

        javax.swing.GroupLayout wds_secondLayout = new javax.swing.GroupLayout(wds_second);
        wds_second.setLayout(wds_secondLayout);
        wds_secondLayout.setHorizontalGroup(
            wds_secondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wds_secondLayout.createSequentialGroup()
                .addGroup(wds_secondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(wds_secondLayout.createSequentialGroup()
                        .addGap(492, 492, 492)
                        .addComponent(wds_sec_title))
                    .addGroup(wds_secondLayout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(wds_sec_pn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(445, Short.MAX_VALUE))
        );
        wds_secondLayout.setVerticalGroup(
            wds_secondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wds_secondLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wds_sec_title)
                .addGap(32, 32, 32)
                .addComponent(wds_sec_pn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );

        parent_wds.add(wds_second, "card3");

        wds_third_viewdetails.setBackground(new java.awt.Color(102, 52, 109));

        wds_third_title.setBackground(new java.awt.Color(255, 255, 255));
        wds_third_title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        wds_third_title.setForeground(new java.awt.Color(255, 255, 255));
        wds_third_title.setText("WORKING DAYS AND HOURS DETAILS");

        wds_third_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wds_third_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        wds_third_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wds_third_tableMouseClicked(evt);
            }
        });
        wds_third_scroll.setViewportView(wds_third_table);

        wds_third_backbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        wds_third_backbtn.setText("back");
        wds_third_backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wds_third_backbtnActionPerformed(evt);
            }
        });

        wds_third_deletebtn.setBackground(new java.awt.Color(102, 102, 102));
        wds_third_deletebtn.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        wds_third_deletebtn.setText("DELETE");
        wds_third_deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wds_third_deletebtnActionPerformed(evt);
            }
        });

        wds_third_editbtn.setBackground(new java.awt.Color(102, 102, 102));
        wds_third_editbtn.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        wds_third_editbtn.setText("EDIT");
        wds_third_editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wds_third_editbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout wds_third_viewdetailsLayout = new javax.swing.GroupLayout(wds_third_viewdetails);
        wds_third_viewdetails.setLayout(wds_third_viewdetailsLayout);
        wds_third_viewdetailsLayout.setHorizontalGroup(
            wds_third_viewdetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wds_third_viewdetailsLayout.createSequentialGroup()
                .addGroup(wds_third_viewdetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(wds_third_viewdetailsLayout.createSequentialGroup()
                        .addGap(596, 596, 596)
                        .addComponent(wds_third_editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(247, 247, 247)
                        .addComponent(wds_third_deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(wds_third_viewdetailsLayout.createSequentialGroup()
                        .addGap(478, 478, 478)
                        .addComponent(wds_third_title))
                    .addGroup(wds_third_viewdetailsLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(wds_third_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 1469, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wds_third_viewdetailsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(wds_third_backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
        );
        wds_third_viewdetailsLayout.setVerticalGroup(
            wds_third_viewdetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wds_third_viewdetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wds_third_title)
                .addGap(28, 28, 28)
                .addComponent(wds_third_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addGroup(wds_third_viewdetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wds_third_editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wds_third_deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(wds_third_backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(402, Short.MAX_VALUE))
        );

        parent_wds.add(wds_third_viewdetails, "card4");

        wds_fourth_update.setBackground(new java.awt.Color(102, 52, 109));

        wds_fourth_title.setBackground(new java.awt.Color(255, 255, 255));
        wds_fourth_title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        wds_fourth_title.setForeground(new java.awt.Color(255, 255, 255));
        wds_fourth_title.setText("UPTADE WORKING DAYS AND HOURS");

        wds_fourth_pn.setBackground(new java.awt.Color(137, 14, 137));
        wds_fourth_pn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        wds_fourth_tid_lbl.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_fourth_tid_lbl.setForeground(new java.awt.Color(255, 255, 255));
        wds_fourth_tid_lbl.setText("Timetable ID");

        test.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        test.setForeground(new java.awt.Color(255, 255, 255));

        wds_fourth_type_lbl.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_fourth_type_lbl.setForeground(new java.awt.Color(255, 255, 255));
        wds_fourth_type_lbl.setText("Timetable Type");

        wds_fourth_type.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_fourth_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Weekend", "Weekdays" }));

        wds_fourth_no_lbl.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_fourth_no_lbl.setForeground(new java.awt.Color(255, 255, 255));
        wds_fourth_no_lbl.setText("Number of Working Days (per week)");

        wds_fourth_ndays.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_fourth_ndays.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
        wds_fourth_ndays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wds_fourth_ndaysActionPerformed(evt);
            }
        });

        wds_fourth_days_lbl.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_fourth_days_lbl.setForeground(new java.awt.Color(255, 255, 255));
        wds_fourth_days_lbl.setText("Working Days");

        up_monday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        up_monday.setText("Monday");

        up_tuesday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        up_tuesday.setText("Tuesday");
        up_tuesday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up_tuesdayActionPerformed(evt);
            }
        });

        up_wednesday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        up_wednesday.setText("Wednesday");

        up_thursday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        up_thursday.setText("Thursday");

        up_friday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        up_friday.setText("Friday");
        up_friday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up_fridayActionPerformed(evt);
            }
        });

        up_saturday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        up_saturday.setText("Saturday");
        up_saturday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up_saturdayActionPerformed(evt);
            }
        });

        up_sunday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        up_sunday.setText("Sunday");

        wds_fourth_time_lbl.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_fourth_time_lbl.setForeground(new java.awt.Color(255, 255, 255));
        wds_fourth_time_lbl.setText("Working Time (per day)");

        wds_fourth_hrs_lbl.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_fourth_hrs_lbl.setForeground(new java.awt.Color(255, 255, 255));
        wds_fourth_hrs_lbl.setText("hours");

        wds_fourth_hrs.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_fourth_hrs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wds_fourth_hrsActionPerformed(evt);
            }
        });

        wds_fourth_mins_lbl.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_fourth_mins_lbl.setForeground(new java.awt.Color(255, 255, 255));
        wds_fourth_mins_lbl.setText("minutes");

        wds_fourth_mins.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_fourth_mins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wds_fourth_minsActionPerformed(evt);
            }
        });

        wds_fourth_slot_lbl.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_fourth_slot_lbl.setForeground(new java.awt.Color(255, 255, 255));
        wds_fourth_slot_lbl.setText("TIme Slot");

        wds_fourth_slot.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        wds_fourth_slot.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 hour", "30 minutes" }));
        wds_fourth_slot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wds_fourth_slotActionPerformed(evt);
            }
        });

        wds_fourth_updatebtn.setBackground(new java.awt.Color(102, 102, 102));
        wds_fourth_updatebtn.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        wds_fourth_updatebtn.setText("UPDATE");
        wds_fourth_updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wds_fourth_updatebtnActionPerformed(evt);
            }
        });

        wds_fourth_backbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        wds_fourth_backbtn.setText("back");
        wds_fourth_backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wds_fourth_backbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout wds_fourth_pnLayout = new javax.swing.GroupLayout(wds_fourth_pn);
        wds_fourth_pn.setLayout(wds_fourth_pnLayout);
        wds_fourth_pnLayout.setHorizontalGroup(
            wds_fourth_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wds_fourth_pnLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(wds_fourth_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wds_fourth_pnLayout.createSequentialGroup()
                        .addComponent(wds_fourth_no_lbl)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(wds_fourth_pnLayout.createSequentialGroup()
                        .addGroup(wds_fourth_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wds_fourth_type_lbl)
                            .addGroup(wds_fourth_pnLayout.createSequentialGroup()
                                .addGroup(wds_fourth_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(wds_fourth_tid_lbl)
                                    .addComponent(wds_fourth_days_lbl)
                                    .addComponent(wds_fourth_time_lbl)
                                    .addComponent(wds_fourth_slot_lbl))
                                .addGap(191, 191, 191)
                                .addGroup(wds_fourth_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(wds_fourth_slot, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(wds_fourth_pnLayout.createSequentialGroup()
                                        .addComponent(wds_fourth_hrs_lbl)
                                        .addGap(18, 18, 18)
                                        .addComponent(wds_fourth_hrs, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(wds_fourth_mins_lbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(wds_fourth_mins, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(wds_fourth_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(wds_fourth_pnLayout.createSequentialGroup()
                                            .addComponent(up_monday, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(29, 29, 29)
                                            .addComponent(up_saturday, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(test, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(wds_fourth_pnLayout.createSequentialGroup()
                                            .addComponent(up_tuesday, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(up_sunday, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(up_wednesday, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(up_thursday, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(up_friday, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(wds_fourth_type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(wds_fourth_ndays, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(0, 40, Short.MAX_VALUE))))
            .addGroup(wds_fourth_pnLayout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(wds_fourth_updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wds_fourth_pnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(wds_fourth_backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        wds_fourth_pnLayout.setVerticalGroup(
            wds_fourth_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wds_fourth_pnLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(wds_fourth_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(test, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wds_fourth_tid_lbl))
                .addGap(33, 33, 33)
                .addGroup(wds_fourth_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wds_fourth_type_lbl)
                    .addComponent(wds_fourth_type, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(wds_fourth_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(wds_fourth_no_lbl)
                    .addComponent(wds_fourth_ndays, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(wds_fourth_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wds_fourth_days_lbl)
                    .addComponent(up_monday)
                    .addComponent(up_saturday))
                .addGap(22, 22, 22)
                .addGroup(wds_fourth_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(up_tuesday)
                    .addComponent(up_sunday))
                .addGap(18, 18, 18)
                .addComponent(up_wednesday)
                .addGap(18, 18, 18)
                .addComponent(up_thursday)
                .addGap(18, 18, 18)
                .addComponent(up_friday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(wds_fourth_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wds_fourth_time_lbl)
                    .addGroup(wds_fourth_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(wds_fourth_hrs_lbl)
                        .addComponent(wds_fourth_mins_lbl)
                        .addComponent(wds_fourth_hrs, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(wds_fourth_mins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(wds_fourth_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wds_fourth_slot_lbl)
                    .addComponent(wds_fourth_slot, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(wds_fourth_updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wds_fourth_backbtn)
                .addGap(95, 95, 95))
        );

        javax.swing.GroupLayout wds_fourth_updateLayout = new javax.swing.GroupLayout(wds_fourth_update);
        wds_fourth_update.setLayout(wds_fourth_updateLayout);
        wds_fourth_updateLayout.setHorizontalGroup(
            wds_fourth_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wds_fourth_updateLayout.createSequentialGroup()
                .addGroup(wds_fourth_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(wds_fourth_updateLayout.createSequentialGroup()
                        .addGap(478, 478, 478)
                        .addComponent(wds_fourth_title))
                    .addGroup(wds_fourth_updateLayout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(wds_fourth_pn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(438, Short.MAX_VALUE))
        );
        wds_fourth_updateLayout.setVerticalGroup(
            wds_fourth_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wds_fourth_updateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wds_fourth_title)
                .addGap(34, 34, 34)
                .addComponent(wds_fourth_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(240, Short.MAX_VALUE))
        );

        parent_wds.add(wds_fourth_update, "card5");

        javax.swing.GroupLayout workingdaysPanelLayout = new javax.swing.GroupLayout(workingdaysPanel);
        workingdaysPanel.setLayout(workingdaysPanelLayout);
        workingdaysPanelLayout.setHorizontalGroup(
            workingdaysPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workingdaysPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(parent_wds, javax.swing.GroupLayout.PREFERRED_SIZE, 1563, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(2877, Short.MAX_VALUE))
        );
        workingdaysPanelLayout.setVerticalGroup(
            workingdaysPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workingdaysPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(parent_wds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Parent.add(workingdaysPanel, "workingdaysPanel");

        javax.swing.GroupLayout timetablesPanelLayout = new javax.swing.GroupLayout(timetablesPanel);
        timetablesPanel.setLayout(timetablesPanelLayout);
        timetablesPanelLayout.setHorizontalGroup(
            timetablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4450, Short.MAX_VALUE)
        );
        timetablesPanelLayout.setVerticalGroup(
            timetablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );

        Parent.add(timetablesPanel, "timetablesPanel");

        statsticsPanel.setBackground(new java.awt.Color(0, 204, 204));

        data_visualization.setBackground(new java.awt.Color(0, 153, 153));

        visualizationTitle.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        visualizationTitle.setText("Data Visualization");

        statisticBtn.setBackground(new java.awt.Color(102, 102, 102));
        statisticBtn.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        statisticBtn.setText("Get Details");
        statisticBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticBtnActionPerformed(evt);
            }
        });

        statisticImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/statistics.jpg"))); // NOI18N

        javax.swing.GroupLayout data_visualizationLayout = new javax.swing.GroupLayout(data_visualization);
        data_visualization.setLayout(data_visualizationLayout);
        data_visualizationLayout.setHorizontalGroup(
            data_visualizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_visualizationLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(statisticBtn)
                .addGap(194, 194, 194))
            .addGroup(data_visualizationLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(statisticImage)
                .addGap(0, 36, Short.MAX_VALUE))
            .addGroup(data_visualizationLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(visualizationTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        data_visualizationLayout.setVerticalGroup(
            data_visualizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_visualizationLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(statisticImage, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(visualizationTitle)
                .addGap(29, 29, 29)
                .addComponent(statisticBtn)
                .addContainerGap())
        );

        javax.swing.GroupLayout statsticsPanelLayout = new javax.swing.GroupLayout(statsticsPanel);
        statsticsPanel.setLayout(statsticsPanelLayout);
        statsticsPanelLayout.setHorizontalGroup(
            statsticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsticsPanelLayout.createSequentialGroup()
                .addGap(478, 478, 478)
                .addComponent(data_visualization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(3505, Short.MAX_VALUE))
        );
        statsticsPanelLayout.setVerticalGroup(
            statsticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsticsPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(data_visualization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(448, Short.MAX_VALUE))
        );

        Parent.add(statsticsPanel, "statsticsPanel");

        locationDetails.setBackground(new java.awt.Color(0, 204, 204));

        locationDet_panel.setBackground(new java.awt.Color(0, 153, 153));

        locationDet_title.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        locationDet_title.setText("Location Details");

        buildingNameLabel.setFont(new java.awt.Font("Calibri Light", 1, 22)); // NOI18N
        buildingNameLabel.setText("Building");

        buildName.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        buildName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildNameActionPerformed(evt);
            }
        });

        search.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        search.setText("SEARCH");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        locDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        locDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                locDetailsMouseClicked(evt);
            }
        });
        locDetailScrolPane.setViewportView(locDetails);

        Delete.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        Delete.setText("DELETE");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        add.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        add.setText("ADD Location");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        edit.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        edit.setText("EDIT Location");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout locationDet_panelLayout = new javax.swing.GroupLayout(locationDet_panel);
        locationDet_panel.setLayout(locationDet_panelLayout);
        locationDet_panelLayout.setHorizontalGroup(
            locationDet_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locationDet_panelLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(locationDet_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(locDetailScrolPane, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(locationDet_panelLayout.createSequentialGroup()
                        .addGroup(locationDet_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buildingNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(locationDet_panelLayout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addGroup(locationDet_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(buildName, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(locationDet_title))))
                        .addGap(18, 18, 18)
                        .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(41, 41, 41)
                .addGroup(locationDet_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        locationDet_panelLayout.setVerticalGroup(
            locationDet_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locationDet_panelLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(locationDet_title)
                .addGap(51, 51, 51)
                .addGroup(locationDet_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buildingNameLabel)
                    .addComponent(buildName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search))
                .addGroup(locationDet_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(locationDet_panelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(locDetailScrolPane, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(locationDet_panelLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(Delete)
                        .addGap(18, 18, 18)
                        .addComponent(add)
                        .addGap(18, 18, 18)
                        .addComponent(edit)))
                .addGap(74, 74, 74))
        );

        javax.swing.GroupLayout locationDetailsLayout = new javax.swing.GroupLayout(locationDetails);
        locationDetails.setLayout(locationDetailsLayout);
        locationDetailsLayout.setHorizontalGroup(
            locationDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locationDetailsLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(locationDet_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(3280, Short.MAX_VALUE))
        );
        locationDetailsLayout.setVerticalGroup(
            locationDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locationDetailsLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(locationDet_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(318, Short.MAX_VALUE))
        );

        Parent.add(locationDetails, "locationDetails");

        addLocation.setBackground(new java.awt.Color(0, 204, 204));

        locationAdd_panel.setBackground(new java.awt.Color(0, 153, 153));

        addBuilding.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        addBuilding.setText("ADD Building");
        addBuilding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBuildingActionPerformed(evt);
            }
        });

        addLoc.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        addLoc.setText("ADD Location");
        addLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLocActionPerformed(evt);
            }
        });

        AddLocationDetTitle.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        AddLocationDetTitle.setText("Add Location Details");

        addBuildingNameLabel.setFont(new java.awt.Font("Calibri Light", 1, 22)); // NOI18N
        addBuildingNameLabel.setText("Building");

        roomLabel.setFont(new java.awt.Font("Calibri Light", 1, 22)); // NOI18N
        roomLabel.setText("Room");

        capacityLabel.setFont(new java.awt.Font("Calibri Light", 1, 22)); // NOI18N
        capacityLabel.setText("Capacity");

        roomTypeLabel.setFont(new java.awt.Font("Calibri Light", 1, 22)); // NOI18N
        roomTypeLabel.setText("Room Type");

        room.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N

        buildName1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        buildName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildName1ActionPerformed(evt);
            }
        });

        capacity.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N

        rType.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        rType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Room Type", "Lecture Hall", "Laboratory" }));
        rType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rTypeActionPerformed(evt);
            }
        });

        addBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addBack.setText("BACK");
        addBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout locationAdd_panelLayout = new javax.swing.GroupLayout(locationAdd_panel);
        locationAdd_panel.setLayout(locationAdd_panelLayout);
        locationAdd_panelLayout.setHorizontalGroup(
            locationAdd_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, locationAdd_panelLayout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addGroup(locationAdd_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roomLabel)
                    .addComponent(addBuildingNameLabel)
                    .addComponent(capacityLabel)
                    .addComponent(roomTypeLabel))
                .addGap(129, 129, 129)
                .addGroup(locationAdd_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddLocationDetTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buildName1)
                    .addComponent(room)
                    .addComponent(capacity)
                    .addComponent(rType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(95, 95, 95)
                .addGroup(locationAdd_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addBack, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(addBuilding, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addLoc, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                .addGap(154, 154, 154))
        );
        locationAdd_panelLayout.setVerticalGroup(
            locationAdd_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locationAdd_panelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(locationAdd_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(locationAdd_panelLayout.createSequentialGroup()
                        .addComponent(AddLocationDetTitle)
                        .addGap(59, 59, 59)
                        .addGroup(locationAdd_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addBuildingNameLabel)
                            .addComponent(buildName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addBuilding))
                        .addGap(33, 33, 33)
                        .addComponent(roomLabel))
                    .addComponent(room, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(locationAdd_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(capacityLabel)
                    .addComponent(capacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(locationAdd_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomTypeLabel)
                    .addComponent(rType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addLoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(addBack)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout addLocationLayout = new javax.swing.GroupLayout(addLocation);
        addLocation.setLayout(addLocationLayout);
        addLocationLayout.setHorizontalGroup(
            addLocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addLocationLayout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(locationAdd_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(3243, Short.MAX_VALUE))
        );
        addLocationLayout.setVerticalGroup(
            addLocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addLocationLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(locationAdd_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(289, Short.MAX_VALUE))
        );

        Parent.add(addLocation, "addLocation");

        editLocation.setBackground(new java.awt.Color(0, 204, 204));

        locationEdit_panel.setBackground(new java.awt.Color(0, 153, 153));

        searchBuildInEditLabel.setFont(new java.awt.Font("Calibri Light", 1, 22)); // NOI18N
        searchBuildInEditLabel.setText("Building");

        editLoc.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        editLoc.setText("EDIT Location");
        editLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editLocActionPerformed(evt);
            }
        });

        roomTypeEditLabel.setFont(new java.awt.Font("Calibri Light", 1, 22)); // NOI18N
        roomTypeEditLabel.setText("Room Type");

        editLocationDetTitle.setFont(new java.awt.Font("Calibri Light", 1, 30)); // NOI18N
        editLocationDetTitle.setText("Edit Location Details");

        delBuild.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        delBuild.setText("DELETE");
        delBuild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBuildActionPerformed(evt);
            }
        });

        roomEditLabel.setFont(new java.awt.Font("Calibri Light", 1, 22)); // NOI18N
        roomEditLabel.setText("Room");

        locationInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        locationInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                locationInfoMouseClicked(evt);
            }
        });
        EditLocationDetailScriollPane.setViewportView(locationInfo);

        room1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N

        sName.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N

        buildName2.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        buildName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildName2ActionPerformed(evt);
            }
        });

        capacity1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N

        editBack.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        editBack.setText("BACK");
        editBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBackActionPerformed(evt);
            }
        });

        capacityEditLabel.setFont(new java.awt.Font("Calibri Light", 1, 22)); // NOI18N
        capacityEditLabel.setText("Capacity");

        editLocSubTitle.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        editLocSubTitle.setText("Enter details to edit");

        rType1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        rType1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Room Type", "Lecture Hall", "Laboratory" }));

        EditBuildLabel.setFont(new java.awt.Font("Calibri Light", 1, 22)); // NOI18N
        EditBuildLabel.setText("Building");

        searchBuild.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        searchBuild.setText("SEARCH");
        searchBuild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBuildActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout locationEdit_panelLayout = new javax.swing.GroupLayout(locationEdit_panel);
        locationEdit_panel.setLayout(locationEdit_panelLayout);
        locationEdit_panelLayout.setHorizontalGroup(
            locationEdit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, locationEdit_panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(editLocationDetTitle)
                .addGap(358, 358, 358))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, locationEdit_panelLayout.createSequentialGroup()
                .addGroup(locationEdit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(locationEdit_panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(editBack, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(locationEdit_panelLayout.createSequentialGroup()
                        .addGroup(locationEdit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(locationEdit_panelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(editLocSubTitle))
                            .addGroup(locationEdit_panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(locationEdit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(roomEditLabel)
                                    .addComponent(capacityEditLabel)
                                    .addComponent(roomTypeEditLabel)))
                            .addGroup(locationEdit_panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(EditBuildLabel)
                                .addGap(77, 77, 77)
                                .addGroup(locationEdit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(editLoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rType1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 177, Short.MAX_VALUE)
                                    .addComponent(capacity1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(room1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(buildName2))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addGroup(locationEdit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EditLocationDetailScriollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, locationEdit_panelLayout.createSequentialGroup()
                                .addComponent(searchBuildInEditLabel)
                                .addGap(39, 39, 39)
                                .addComponent(sName, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchBuild, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(delBuild, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(25, 25, 25))
        );
        locationEdit_panelLayout.setVerticalGroup(
            locationEdit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locationEdit_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editLocationDetTitle)
                .addGap(53, 53, 53)
                .addGroup(locationEdit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editLocSubTitle)
                    .addComponent(searchBuildInEditLabel)
                    .addComponent(sName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBuild)
                    .addComponent(delBuild))
                .addGap(38, 38, 38)
                .addGroup(locationEdit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(locationEdit_panelLayout.createSequentialGroup()
                        .addGroup(locationEdit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EditBuildLabel)
                            .addComponent(buildName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(locationEdit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(roomEditLabel)
                            .addComponent(room1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(locationEdit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(capacityEditLabel)
                            .addComponent(capacity1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(locationEdit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rType1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomTypeEditLabel))
                        .addGap(59, 59, 59)
                        .addComponent(editLoc))
                    .addComponent(EditLocationDetailScriollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(editBack)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout editLocationLayout = new javax.swing.GroupLayout(editLocation);
        editLocation.setLayout(editLocationLayout);
        editLocationLayout.setHorizontalGroup(
            editLocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editLocationLayout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(locationEdit_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(3226, Short.MAX_VALUE))
        );
        editLocationLayout.setVerticalGroup(
            editLocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editLocationLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(locationEdit_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
        );

        Parent.add(editLocation, "editLocation");

        dataVisualization.setBackground(new java.awt.Color(0, 204, 204));

        statistical_panel.setBackground(new java.awt.Color(0, 153, 153));

        statisticTitel.setFont(new java.awt.Font("Calibri Light", 1, 22)); // NOI18N
        statisticTitel.setText("Statistical View");

        Visualization_Panel.setBackground(new java.awt.Color(153, 153, 153));

        studentStatisticData.setBackground(new java.awt.Color(0, 0, 0));
        studentStatisticData.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        studentStatisticData.setText("Student");
        studentStatisticData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentStatisticDataActionPerformed(evt);
            }
        });

        panelChart.setBackground(new java.awt.Color(204, 204, 255));
        panelChart.setLayout(new java.awt.BorderLayout());

        lecturersStatisticData.setBackground(new java.awt.Color(51, 51, 51));
        lecturersStatisticData.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        lecturersStatisticData.setText("Lecturers");
        lecturersStatisticData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturersStatisticDataActionPerformed(evt);
            }
        });

        subjectsStatisticData.setBackground(new java.awt.Color(51, 51, 51));
        subjectsStatisticData.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        subjectsStatisticData.setText("Subjects");
        subjectsStatisticData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectsStatisticDataActionPerformed(evt);
            }
        });

        lecturersChrt.setBackground(new java.awt.Color(204, 204, 255));
        lecturersChrt.setLayout(new java.awt.BorderLayout());

        subjectChart.setBackground(new java.awt.Color(204, 204, 255));
        subjectChart.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout Visualization_PanelLayout = new javax.swing.GroupLayout(Visualization_Panel);
        Visualization_Panel.setLayout(Visualization_PanelLayout);
        Visualization_PanelLayout.setHorizontalGroup(
            Visualization_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Visualization_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Visualization_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelChart, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                    .addComponent(lecturersStatisticData, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentStatisticData, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lecturersChrt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(64, 64, 64)
                .addGroup(Visualization_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subjectsStatisticData)
                    .addComponent(subjectChart, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        Visualization_PanelLayout.setVerticalGroup(
            Visualization_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Visualization_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Visualization_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subjectsStatisticData, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(studentStatisticData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Visualization_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Visualization_PanelLayout.createSequentialGroup()
                        .addComponent(panelChart, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(lecturersStatisticData)
                        .addGap(26, 26, 26)
                        .addComponent(lecturersChrt, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
                    .addComponent(subjectChart, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout statistical_panelLayout = new javax.swing.GroupLayout(statistical_panel);
        statistical_panel.setLayout(statistical_panelLayout);
        statistical_panelLayout.setHorizontalGroup(
            statistical_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statistical_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Visualization_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(statistical_panelLayout.createSequentialGroup()
                .addGap(516, 516, 516)
                .addComponent(statisticTitel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        statistical_panelLayout.setVerticalGroup(
            statistical_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statistical_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statisticTitel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Visualization_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dataVisualizationLayout = new javax.swing.GroupLayout(dataVisualization);
        dataVisualization.setLayout(dataVisualizationLayout);
        dataVisualizationLayout.setHorizontalGroup(
            dataVisualizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataVisualizationLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(statistical_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(3149, Short.MAX_VALUE))
        );
        dataVisualizationLayout.setVerticalGroup(
            dataVisualizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataVisualizationLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(statistical_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        Parent.add(dataVisualization, "dataVisualization");

        subjects.setBackground(new java.awt.Color(102, 0, 0));

        jPanel27_27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27_27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        subject_add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        subject_add.setText("ADD NEW SUBJECT");
        subject_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subject_addActionPerformed(evt);
            }
        });

        jLabel29_29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetable/subject (2).png"))); // NOI18N

        javax.swing.GroupLayout jPanel27_27Layout = new javax.swing.GroupLayout(jPanel27_27);
        jPanel27_27.setLayout(jPanel27_27Layout);
        jPanel27_27Layout.setHorizontalGroup(
            jPanel27_27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27_27Layout.createSequentialGroup()
                .addGroup(jPanel27_27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27_27Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel79_79))
                    .addGroup(jPanel27_27Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel29_29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel80_80))
                    .addGroup(jPanel27_27Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(subject_add)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel27_27Layout.setVerticalGroup(
            jPanel27_27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27_27Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel27_27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel80_80, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29_29, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel79_79)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addComponent(subject_add)
                .addGap(33, 33, 33))
        );

        jPanel28_28.setBackground(new java.awt.Color(0, 0, 0));
        jPanel28_28.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        jLabel81_81.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel81_81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81_81.setText("SUBJECTS");

        javax.swing.GroupLayout jPanel28_28Layout = new javax.swing.GroupLayout(jPanel28_28);
        jPanel28_28.setLayout(jPanel28_28Layout);
        jPanel28_28Layout.setHorizontalGroup(
            jPanel28_28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28_28Layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(jLabel81_81)
                .addGap(129, 129, 129))
        );
        jPanel28_28Layout.setVerticalGroup(
            jPanel28_28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28_28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel81_81)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel29_29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29_29.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        subject_details.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        subject_details.setText("SUBJECT DETAILS");
        subject_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subject_detailsActionPerformed(evt);
            }
        });

        jLabel28_28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetable/subject (2).png"))); // NOI18N

        javax.swing.GroupLayout jPanel29_29Layout = new javax.swing.GroupLayout(jPanel29_29);
        jPanel29_29.setLayout(jPanel29_29Layout);
        jPanel29_29Layout.setHorizontalGroup(
            jPanel29_29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29_29Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel82_82)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28_28)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29_29Layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addComponent(subject_details)
                .addGap(74, 74, 74))
        );
        jPanel29_29Layout.setVerticalGroup(
            jPanel29_29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29_29Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel29_29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel82_82, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28_28, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(subject_details)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout subjectsLayout = new javax.swing.GroupLayout(subjects);
        subjects.setLayout(subjectsLayout);
        subjectsLayout.setHorizontalGroup(
            subjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subjectsLayout.createSequentialGroup()
                .addGroup(subjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subjectsLayout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(jPanel27_27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jPanel29_29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(subjectsLayout.createSequentialGroup()
                        .addGap(438, 438, 438)
                        .addComponent(jPanel28_28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(3446, Short.MAX_VALUE))
        );
        subjectsLayout.setVerticalGroup(
            subjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subjectsLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel28_28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addGroup(subjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel27_27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel29_29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(298, Short.MAX_VALUE))
        );

        Parent.add(subjects, "subjects");

        subjects_add.setBackground(new java.awt.Color(0, 0, 102));

        add_subs.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add_subs.setText(" Add Subject ");
        add_subs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        add_subs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_subsActionPerformed(evt);
            }
        });

        jPanel30_30.setBackground(new java.awt.Color(0, 0, 0));
        jPanel30_30.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel90_90.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel90_90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90_90.setText("ADD SUBJECT DETAILS");

        javax.swing.GroupLayout jPanel30_30Layout = new javax.swing.GroupLayout(jPanel30_30);
        jPanel30_30.setLayout(jPanel30_30Layout);
        jPanel30_30Layout.setHorizontalGroup(
            jPanel30_30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30_30Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jLabel90_90)
                .addGap(53, 53, 53))
        );
        jPanel30_30Layout.setVerticalGroup(
            jPanel30_30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30_30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel90_90)
                .addContainerGap())
        );

        jButton17_17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton17_17.setText(" Back ");
        jButton17_17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton17_17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17_17ActionPerformed(evt);
            }
        });

        jPanel36_36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36_36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel92_92.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel92_92.setText("Subject Code");

        sa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                saKeyPressed(evt);
            }
        });

        jLabel30_30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel30_30.setText("Subject Name");

        sa1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sa1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sa1KeyPressed(evt);
            }
        });

        jLabel91_91.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel91_91.setText("Offered Year");

        sa2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sa2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Year", "1st year", "2nd year", "3rd year", "4th year" }));
        sa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sa2ActionPerformed(evt);
            }
        });

        jLabel94_94.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel94_94.setText("Offered Semester");

        sa3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sa3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Semester", "1st sem", "2nd sem" }));

        jLabel96_96.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel96_96.setText("Number of Lecture Hours");

        sa4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sa4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Lecture Hours", "1", "1.30", "2", "2.30", "3", "3.30", "4" }));

        jLabel93_93.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel93_93.setText("Number of Tutorial Hours");

        sa5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sa5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Tutorial Hours", "1", "1.30", "2", "2.30", "3" }));

        jLabel95_95.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel95_95.setText("Number of Lab Hours");

        sa6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sa6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Lab Hours", "1", "1.30", "2", "2.30", "3" }));

        jLabel97_97.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel97_97.setText("Number of Evaluation Hours");

        sa7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sa7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Evaluation Hours", "1", "1.30", "2", "2.30", "3", "3.30", "4" }));

        javax.swing.GroupLayout jPanel36_36Layout = new javax.swing.GroupLayout(jPanel36_36);
        jPanel36_36.setLayout(jPanel36_36Layout);
        jPanel36_36Layout.setHorizontalGroup(
            jPanel36_36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36_36Layout.createSequentialGroup()
                .addGroup(jPanel36_36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36_36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel36_36Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(jPanel36_36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel91_91)
                                .addComponent(jLabel94_94)
                                .addGroup(jPanel36_36Layout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addComponent(jLabel92_92))
                                .addComponent(jLabel30_30)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36_36Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jLabel96_96)))
                    .addGroup(jPanel36_36Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel36_36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel95_95)
                            .addComponent(jLabel93_93)
                            .addComponent(jLabel97_97))))
                .addGap(60, 60, 60)
                .addGroup(jPanel36_36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(sa6, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sa5, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sa4, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sa3, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sa2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sa1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sa, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sa7, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 40, Short.MAX_VALUE))
        );
        jPanel36_36Layout.setVerticalGroup(
            jPanel36_36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36_36Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel36_36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel36_36Layout.createSequentialGroup()
                        .addGroup(jPanel36_36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel92_92, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(jLabel30_30)))
                .addGap(50, 50, 50)
                .addGroup(jPanel36_36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel91_91)
                    .addComponent(sa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel36_36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94_94)
                    .addComponent(sa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel36_36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel96_96))
                .addGap(42, 42, 42)
                .addGroup(jPanel36_36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93_93)
                    .addComponent(sa5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel36_36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel95_95)
                    .addComponent(sa6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel36_36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel97_97)
                    .addComponent(sa7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout subjects_addLayout = new javax.swing.GroupLayout(subjects_add);
        subjects_add.setLayout(subjects_addLayout);
        subjects_addLayout.setHorizontalGroup(
            subjects_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subjects_addLayout.createSequentialGroup()
                .addGroup(subjects_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subjects_addLayout.createSequentialGroup()
                        .addGap(467, 467, 467)
                        .addComponent(jPanel30_30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(subjects_addLayout.createSequentialGroup()
                        .addGap(410, 410, 410)
                        .addComponent(jPanel36_36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(subjects_addLayout.createSequentialGroup()
                        .addGap(595, 595, 595)
                        .addComponent(jButton17_17, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(add_subs, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(3483, Short.MAX_VALUE))
        );
        subjects_addLayout.setVerticalGroup(
            subjects_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subjects_addLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel30_30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel36_36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(subjects_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton17_17, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(subjects_addLayout.createSequentialGroup()
                        .addComponent(add_subs, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addGap(7, 7, 7)))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        Parent.add(subjects_add, "subjects_add");

        subject_detail1.setBackground(new java.awt.Color(0, 0, 102));

        jLabel98_98.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel98_98.setText("Subject Code");

        jLabel99_99.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel99_99.setText("Subject Name");

        jLabel100_100.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel100_100.setText("Offered Year");

        jLabel101_101.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel101_101.setText("Offered Semester");

        jLabel102_102.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel102_102.setText("Number of Lecture Hours");

        jLabel103_103.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel103_103.setText("Number of Tutorial Hours");

        jLabel104_104.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel104_104.setText("Number of Lab Hours");

        jLabel105_105.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel105_105.setText("Number of Evaluation Hours");

        jPanel31_31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31_31.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel106.setText("Add Subject Details");

        javax.swing.GroupLayout jPanel31_31Layout = new javax.swing.GroupLayout(jPanel31_31);
        jPanel31_31.setLayout(jPanel31_31Layout);
        jPanel31_31Layout.setHorizontalGroup(
            jPanel31_31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31_31Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel106)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel31_31Layout.setVerticalGroup(
            jPanel31_31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31_31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel106)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        edit_sub.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        edit_sub.setText(" Edit ");
        edit_sub.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        edit_sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_subActionPerformed(evt);
            }
        });

        delete_sub.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        delete_sub.setText(" Delete ");
        delete_sub.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        delete_sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_subActionPerformed(evt);
            }
        });

        jButton20_20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton20_20.setText(" Back ");
        jButton20_20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton20_20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20_20ActionPerformed(evt);
            }
        });

        jPanel15_15.setBackground(new java.awt.Color(0, 0, 0));
        jPanel15_15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel115_115.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel115_115.setForeground(new java.awt.Color(255, 255, 255));
        jLabel115_115.setText("SUBJECT DETAILS");

        javax.swing.GroupLayout jPanel15_15Layout = new javax.swing.GroupLayout(jPanel15_15);
        jPanel15_15.setLayout(jPanel15_15Layout);
        jPanel15_15Layout.setHorizontalGroup(
            jPanel15_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15_15Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel115_115)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel15_15Layout.setVerticalGroup(
            jPanel15_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15_15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel115_115)
                .addContainerGap())
        );

        delete_subjectdetail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        delete_subjectdetail.setText("Delete");
        delete_subjectdetail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        delete_subjectdetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_subjectdetailActionPerformed(evt);
            }
        });

        jPanel37_37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37_37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel107_107.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel107_107.setText("Subject Code");

        sd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sd.setForeground(new java.awt.Color(102, 102, 102));
        sd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sdActionPerformed(evt);
            }
        });

        jLabel108_108.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel108_108.setText("Subject Name");

        sd1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sd1.setForeground(new java.awt.Color(204, 204, 204));
        sd1.setEnabled(false);
        sd1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sd1KeyPressed(evt);
            }
        });

        jLabel109_109.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel109_109.setText("Offered Year");

        sd2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sd2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select year", "1st year", "2nd year", "3rd year", "4th year" }));
        sd2.setEnabled(false);

        jLabel110_110.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel110_110.setText("Offered Semester");

        sd3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sd3.setForeground(new java.awt.Color(204, 204, 204));
        sd3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Semester", "1st sem", "2nd sem" }));
        sd3.setEnabled(false);

        jLabel111_111.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel111_111.setText("Number of Lecture Hours");

        jLabel113_113.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel113_113.setText("Number of Tutorial Hours");

        sd4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sd4.setForeground(new java.awt.Color(204, 204, 204));
        sd4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Lecture Hours", "1", "1.30", "2", "2.30", "3", "3.30", "4" }));
        sd4.setEnabled(false);

        sd5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sd5.setForeground(new java.awt.Color(204, 204, 204));
        sd5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Tutorial Hours", "1", "1.30", "2", "2.30", "3" }));
        sd5.setEnabled(false);

        jLabel112_112.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel112_112.setText("Number of Lab Hours");

        sd6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sd6.setForeground(new java.awt.Color(204, 204, 204));
        sd6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Lab Hours", "1", "1.30", "2", "2.30", "3" }));
        sd6.setEnabled(false);

        jLabel114_114.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel114_114.setText("Number of Evaluation Hours");

        sd7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sd7.setForeground(new java.awt.Color(204, 204, 204));
        sd7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Evaluation Hours", "1", "1.30", "2", "2.30", "3", "3.30", "4" }));
        sd7.setEnabled(false);

        view_sub.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        view_sub.setText("View");
        view_sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_subActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37_37Layout = new javax.swing.GroupLayout(jPanel37_37);
        jPanel37_37.setLayout(jPanel37_37Layout);
        jPanel37_37Layout.setHorizontalGroup(
            jPanel37_37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37_37Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel37_37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel37_37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel37_37Layout.createSequentialGroup()
                            .addGroup(jPanel37_37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel108_108)
                                .addComponent(jLabel107_107))
                            .addGap(98, 98, 98)
                            .addGroup(jPanel37_37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(sd, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                .addComponent(sd1)))
                        .addGroup(jPanel37_37Layout.createSequentialGroup()
                            .addGroup(jPanel37_37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel110_110)
                                .addComponent(jLabel109_109))
                            .addGap(70, 70, 70)
                            .addGroup(jPanel37_37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sd2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sd3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sd4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sd5, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sd6, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel37_37Layout.createSequentialGroup()
                        .addComponent(jLabel114_114)
                        .addGap(18, 18, 18)
                        .addComponent(sd7, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel37_37Layout.createSequentialGroup()
                        .addGroup(jPanel37_37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel111_111)
                            .addComponent(jLabel113_113)
                            .addComponent(jLabel112_112))
                        .addGap(228, 228, 228)))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(view_sub)
                .addGap(24, 24, 24))
        );
        jPanel37_37Layout.setVerticalGroup(
            jPanel37_37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37_37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37_37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel37_37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(view_sub))
                    .addComponent(jLabel107_107))
                .addGap(33, 33, 33)
                .addGroup(jPanel37_37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel108_108))
                .addGap(39, 39, 39)
                .addGroup(jPanel37_37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel109_109))
                .addGap(53, 53, 53)
                .addGroup(jPanel37_37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel110_110)
                    .addComponent(sd3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel37_37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel111_111)
                    .addComponent(sd4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel37_37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sd5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel113_113))
                .addGap(60, 60, 60)
                .addGroup(jPanel37_37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sd6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel112_112))
                .addGap(56, 56, 56)
                .addGroup(jPanel37_37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sd7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel114_114))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        subjectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4_4.setViewportView(subjectTable);

        javax.swing.GroupLayout subject_detail1Layout = new javax.swing.GroupLayout(subject_detail1);
        subject_detail1.setLayout(subject_detail1Layout);
        subject_detail1Layout.setHorizontalGroup(
            subject_detail1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subject_detail1Layout.createSequentialGroup()
                .addContainerGap(1508, Short.MAX_VALUE)
                .addComponent(delete_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2742, 2742, 2742))
            .addGroup(subject_detail1Layout.createSequentialGroup()
                .addGroup(subject_detail1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subject_detail1Layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(jButton20_20, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(edit_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(delete_subjectdetail, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(subject_detail1Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jPanel15_15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(subject_detail1Layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jPanel37_37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(subject_detail1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(subject_detail1Layout.createSequentialGroup()
                    .addGap(1526, 1526, 1526)
                    .addGroup(subject_detail1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subject_detail1Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(subject_detail1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel99_99)
                                .addComponent(jLabel98_98)
                                .addComponent(jLabel100_100)
                                .addComponent(jLabel101_101)))
                        .addGroup(subject_detail1Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addGroup(subject_detail1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel104_104, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, subject_detail1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel102_102)
                                    .addComponent(jLabel103_103))))
                        .addComponent(jLabel105_105, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addContainerGap(2577, Short.MAX_VALUE)))
            .addGroup(subject_detail1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(subject_detail1Layout.createSequentialGroup()
                    .addGap(1477, 1477, 1477)
                    .addComponent(jPanel31_31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(2529, Short.MAX_VALUE)))
        );
        subject_detail1Layout.setVerticalGroup(
            subject_detail1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subject_detail1Layout.createSequentialGroup()
                .addContainerGap(1776, Short.MAX_VALUE)
                .addComponent(delete_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145))
            .addGroup(subject_detail1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15_15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(subject_detail1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subject_detail1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel37_37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(subject_detail1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jScrollPane4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(subject_detail1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton20_20, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete_subjectdetail, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(subject_detail1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(subject_detail1Layout.createSequentialGroup()
                    .addGap(238, 238, 238)
                    .addComponent(jLabel98_98, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(jLabel99_99)
                    .addGap(28, 28, 28)
                    .addComponent(jLabel100_100)
                    .addGap(28, 28, 28)
                    .addComponent(jLabel101_101)
                    .addGap(30, 30, 30)
                    .addComponent(jLabel102_102)
                    .addGap(31, 31, 31)
                    .addComponent(jLabel103_103)
                    .addGap(42, 42, 42)
                    .addComponent(jLabel104_104)
                    .addGap(42, 42, 42)
                    .addComponent(jLabel105_105)
                    .addContainerGap(1314, Short.MAX_VALUE)))
            .addGroup(subject_detail1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(subject_detail1Layout.createSequentialGroup()
                    .addGap(432, 432, 432)
                    .addComponent(jPanel31_31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1475, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout subject_detailLayout = new javax.swing.GroupLayout(subject_detail);
        subject_detail.setLayout(subject_detailLayout);
        subject_detailLayout.setHorizontalGroup(
            subject_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4450, Short.MAX_VALUE)
            .addGroup(subject_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(subject_detailLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(subject_detail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        subject_detailLayout.setVerticalGroup(
            subject_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1959, Short.MAX_VALUE)
            .addGroup(subject_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(subject_detailLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(subject_detail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Parent.add(subject_detail, "subject_detail");

        subject_edit.setBackground(new java.awt.Color(0, 51, 102));

        update_sub.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        update_sub.setText(" Update Details ");
        update_sub.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        update_sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_subActionPerformed(evt);
            }
        });

        jPanel32_32.setBackground(new java.awt.Color(0, 0, 0));
        jPanel32_32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel124_124.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel124_124.setForeground(new java.awt.Color(255, 255, 255));
        jLabel124_124.setText("EDIT SUBJECT DETAILS");

        javax.swing.GroupLayout jPanel32_32Layout = new javax.swing.GroupLayout(jPanel32_32);
        jPanel32_32.setLayout(jPanel32_32Layout);
        jPanel32_32Layout.setHorizontalGroup(
            jPanel32_32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32_32Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel124_124)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel32_32Layout.setVerticalGroup(
            jPanel32_32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32_32Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel124_124)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel38_38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38_38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel116_116.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel116_116.setText("Subject Code");

        se.setEditable(false);
        se.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        se.setForeground(new java.awt.Color(102, 102, 102));
        se.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                seKeyPressed(evt);
            }
        });

        jLabel117_117.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel117_117.setText("Subject Name");

        se1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        se1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                se1KeyPressed(evt);
            }
        });

        jLabel118_118.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel118_118.setText("Offered Year");

        se2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        se2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select year", "1st year", "2nd year", "3rd year", "4th year" }));

        jLabel119_119.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel119_119.setText("Offered Semester");

        se3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        se3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Semester", "1st sem", "2nd sem" }));

        jLabel120_120.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel120_120.setText("Number of Lecture Hours");

        se4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        se4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Lecture Hours", "1", "1.30", "2", "2.30", "3", "3.30", "4" }));

        jLabel121_121.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel121_121.setText("Number of Tutorial Hours");

        se5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        se5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Tutorial Hours", "1", "1.30", "2", "2.30", "3" }));

        jLabel122_122.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel122_122.setText("Number of Lab Hours");

        se6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        se6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Lab Hours", "1", "1.30", "2", "2.30", "3" }));

        jLabel123_123.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel123_123.setText("Number of Evaluation Hours");

        se7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        se7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Evaluation Hours", "1", "1.30", "2", "2.30", "3", "3.30", "4" }));

        javax.swing.GroupLayout jPanel38_38Layout = new javax.swing.GroupLayout(jPanel38_38);
        jPanel38_38.setLayout(jPanel38_38Layout);
        jPanel38_38Layout.setHorizontalGroup(
            jPanel38_38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38_38Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel38_38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38_38Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel38_38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel117_117)
                            .addComponent(jLabel116_116)))
                    .addComponent(jLabel121_121)
                    .addComponent(jLabel122_122)
                    .addComponent(jLabel120_120)
                    .addComponent(jLabel123_123)
                    .addComponent(jLabel119_119)
                    .addComponent(jLabel118_118))
                .addGap(109, 109, 109)
                .addGroup(jPanel38_38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(se, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel38_38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(se6, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(se5, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(se4, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(se3, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(se2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(se1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(se7, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel38_38Layout.setVerticalGroup(
            jPanel38_38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38_38Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel38_38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel116_116, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(se, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel38_38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38_38Layout.createSequentialGroup()
                        .addComponent(jLabel117_117)
                        .addGap(54, 54, 54)
                        .addGroup(jPanel38_38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(se2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel118_118))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel38_38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(se3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel119_119))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel38_38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(se4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel120_120))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel38_38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel38_38Layout.createSequentialGroup()
                                .addComponent(se5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addGroup(jPanel38_38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(se6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel122_122))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel38_38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(se7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel123_123)))
                            .addComponent(jLabel121_121)))
                    .addComponent(se1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jButton23_23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton23_23.setText(" Back ");
        jButton23_23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton23_23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23_23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout subject_editLayout = new javax.swing.GroupLayout(subject_edit);
        subject_edit.setLayout(subject_editLayout);
        subject_editLayout.setHorizontalGroup(
            subject_editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subject_editLayout.createSequentialGroup()
                .addGroup(subject_editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subject_editLayout.createSequentialGroup()
                        .addGap(381, 381, 381)
                        .addComponent(jPanel38_38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(subject_editLayout.createSequentialGroup()
                        .addGap(614, 614, 614)
                        .addComponent(jButton23_23, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(update_sub))
                    .addGroup(subject_editLayout.createSequentialGroup()
                        .addGap(485, 485, 485)
                        .addComponent(jPanel32_32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(3399, Short.MAX_VALUE))
        );
        subject_editLayout.setVerticalGroup(
            subject_editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subject_editLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel32_32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel38_38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subject_editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23_23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        Parent.add(subject_edit, "subject_edit");

        studentPanel.setBackground(new java.awt.Color(102, 51, 109));
        studentPanel.setBorder(new javax.swing.border.MatteBorder(null));

        jPanel14.setBackground(new java.awt.Color(132, 57, 132));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/graduated (1).png"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Segoe UI Semibold", 2, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(220, 220, 220));
        jLabel21.setText("Academic Year and Semester");

        jButton1.setBackground(new java.awt.Color(153, 0, 153));
        jButton1.setForeground(new java.awt.Color(102, 0, 0));
        jButton1.setText(">>>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(143, 143, 143))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(30, 30, 30)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jPanel16.setBackground(new java.awt.Color(132, 57, 132));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/group (1).png"))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Segoe UI Semibold", 2, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(220, 220, 220));
        jLabel26.setText("Subgroup Numbers");

        jButton3.setBackground(new java.awt.Color(255, 153, 102));
        jButton3.setForeground(new java.awt.Color(102, 0, 0));
        jButton3.setText(">>>");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(145, 145, 145))))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(28, 28, 28)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPanel19.setBackground(new java.awt.Color(132, 57, 132));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/books.png"))); // NOI18N

        jLabel32.setFont(new java.awt.Font("Segoe UI Semibold", 2, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(220, 220, 220));
        jLabel32.setText("Programmes");

        jButton6.setBackground(new java.awt.Color(255, 153, 102));
        jButton6.setForeground(new java.awt.Color(102, 0, 0));
        jButton6.setText(">>>");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel31))
                        .addGap(146, 146, 146))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164))))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addGap(33, 33, 33)
                .addComponent(jLabel32)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPanel20.setBackground(new java.awt.Color(132, 57, 132));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/group (2).png"))); // NOI18N

        jLabel34.setFont(new java.awt.Font("Segoe UI Semibold", 2, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(220, 220, 220));
        jLabel34.setText("Group Numbers");

        jButton7.setBackground(new java.awt.Color(255, 153, 102));
        jButton7.setForeground(new java.awt.Color(102, 0, 0));
        jButton7.setText(">>>");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel33)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addComponent(jLabel34)
                .addGap(124, 124, 124))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addComponent(jLabel34)
                .addGap(34, 34, 34)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout studentPanelLayout = new javax.swing.GroupLayout(studentPanel);
        studentPanel.setLayout(studentPanelLayout);
        studentPanelLayout.setHorizontalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPanelLayout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, studentPanelLayout.createSequentialGroup()
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(studentPanelLayout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(3103, Short.MAX_VALUE))
        );
        studentPanelLayout.setVerticalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );

        Parent.add(studentPanel, "studentPanel");

        tagsPanel.setBackground(new java.awt.Color(102, 51, 109));

        jTable4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tag Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setGridColor(new java.awt.Color(255, 255, 255));
        jTable4.setRowHeight(25);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable4);

        jPanel35.setBackground(new java.awt.Color(135, 19, 135));

        jLabel105.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(255, 255, 255));
        jLabel105.setText("Tag");

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addGap(776, 776, 776)
                .addComponent(jLabel105)
                .addContainerGap(764, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-75.png"))); // NOI18N
        jLabel51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel51MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tagsPanelLayout = new javax.swing.GroupLayout(tagsPanel);
        tagsPanel.setLayout(tagsPanelLayout);
        tagsPanelLayout.setHorizontalGroup(
            tagsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tagsPanelLayout.createSequentialGroup()
                .addGroup(tagsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tagsPanelLayout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tagsPanelLayout.createSequentialGroup()
                        .addGap(784, 784, 784)
                        .addComponent(jLabel51)))
                .addContainerGap(2857, Short.MAX_VALUE))
        );
        tagsPanelLayout.setVerticalGroup(
            tagsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tagsPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(jLabel51)
                .addGap(80, 80, 80))
        );

        Parent.add(tagsPanel, "tagsPanel");

        academicYear.setBackground(new java.awt.Color(102, 51, 109));

        jScrollPane1.setBackground(new java.awt.Color(153, 0, 153));
        jScrollPane1.setBorder(null);
        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Academic Year and Semester", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setRowHeight(25);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel4.setBackground(new java.awt.Color(135, 19, 135));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Academic Year and Semester");

        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-50.png"))); // NOI18N
        jLabel69.setToolTipText("");
        jLabel69.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel69MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel69)
                .addGap(501, 501, 501)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(547, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-75.png"))); // NOI18N
        jLabel70.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel70MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout academicYearLayout = new javax.swing.GroupLayout(academicYear);
        academicYear.setLayout(academicYearLayout);
        academicYearLayout.setHorizontalGroup(
            academicYearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(academicYearLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2857, Short.MAX_VALUE))
            .addGroup(academicYearLayout.createSequentialGroup()
                .addGroup(academicYearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(academicYearLayout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(academicYearLayout.createSequentialGroup()
                        .addGap(740, 740, 740)
                        .addComponent(jLabel70)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        academicYearLayout.setVerticalGroup(
            academicYearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(academicYearLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jLabel70)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        Parent.add(academicYear, "academicYear");

        addAcademicYear.setBackground(new java.awt.Color(102, 51, 109));

        jPanel17.setBackground(new java.awt.Color(137, 14, 137));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Year and Semester");
        jPanel17.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 73, -1, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Description");
        jPanel17.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 181, -1, -1));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jTextField1.setBorder(null);
        jTextField1.setOpaque(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel17.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 78, 310, 30));

        jButton4.setText("Save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 406, 99, 41));

        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png"))); // NOI18N
        jPanel17.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 73, -1, -1));

        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4.png"))); // NOI18N
        jPanel17.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 180, -1, -1));

        jScrollPane3.setBackground(new java.awt.Color(235, 235, 235));
        jScrollPane3.setBorder(null);
        jScrollPane3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jScrollPane3.setMinimumSize(new java.awt.Dimension(350, 190));
        jScrollPane3.setOpaque(false);

        jTextArea1.setBackground(new java.awt.Color(235, 235, 235));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jTextArea1.setOpaque(false);
        jTextArea1.setSelectedTextColor(new java.awt.Color(235, 235, 235));
        jScrollPane3.setViewportView(jTextArea1);

        jPanel17.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 190, 320, 130));

        jPanel6.setBackground(new java.awt.Color(135, 19, 135));

        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-50.png"))); // NOI18N
        jLabel74.setToolTipText("");
        jLabel74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel74MouseClicked(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Add New Academic Year and Semester");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel74)
                .addGap(405, 405, 405)
                .addComponent(jLabel24)
                .addContainerGap(512, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel74))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout addAcademicYearLayout = new javax.swing.GroupLayout(addAcademicYear);
        addAcademicYear.setLayout(addAcademicYearLayout);
        addAcademicYearLayout.setHorizontalGroup(
            addAcademicYearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addAcademicYearLayout.createSequentialGroup()
                .addGroup(addAcademicYearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addAcademicYearLayout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(2857, Short.MAX_VALUE))
        );
        addAcademicYearLayout.setVerticalGroup(
            addAcademicYearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addAcademicYearLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        Parent.add(addAcademicYear, "addAcademicYear");

        editAcademicYear.setBackground(new java.awt.Color(102, 51, 109));
        editAcademicYear.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBackground(new java.awt.Color(137, 14, 137));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Year and Semester");
        jPanel18.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 67, -1, -1));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Description");
        jPanel18.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 183, -1, -1));

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jTextField2.setBorder(null);
        jTextField2.setOpaque(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        jPanel18.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 320, 30));

        jButton5.setText("Update");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 99, 41));

        jButton8.setText("Delete");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, 99, 41));

        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png"))); // NOI18N
        jPanel18.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 67, -1, -1));

        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png"))); // NOI18N
        jPanel18.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, -1));

        jTextField4.setBackground(new java.awt.Color(235, 235, 235));
        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jTextField4.setBorder(null);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });
        jPanel18.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 183, 320, 30));

        editAcademicYear.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 770, 480));

        jPanel7.setBackground(new java.awt.Color(135, 19, 135));

        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-50.png"))); // NOI18N
        jLabel75.setToolTipText("");
        jLabel75.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel75MouseClicked(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Edit Academic Year and Semester");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel75)
                .addGap(426, 426, 426)
                .addComponent(jLabel29)
                .addContainerGap(566, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel75))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        editAcademicYear.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 46, -1, -1));

        Parent.add(editAcademicYear, "editAcademicYear");

        programme.setBackground(new java.awt.Color(102, 51, 109));

        jScrollPane2.setBorder(null);
        jScrollPane2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Programme", "Start Academic Year and Semester", "End Academic Year and Semester"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(255, 255, 255));
        jTable2.setRowHeight(25);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel8.setBackground(new java.awt.Color(135, 19, 135));

        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-50.png"))); // NOI18N
        jLabel79.setToolTipText("");
        jLabel79.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel79MouseClicked(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Programme");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel79)
                .addGap(568, 568, 568)
                .addComponent(jLabel38)
                .addContainerGap(727, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-75.png"))); // NOI18N
        jLabel71.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel71MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout programmeLayout = new javax.swing.GroupLayout(programme);
        programme.setLayout(programmeLayout);
        programmeLayout.setHorizontalGroup(
            programmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(programmeLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2857, Short.MAX_VALUE))
            .addGroup(programmeLayout.createSequentialGroup()
                .addGroup(programmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(programmeLayout.createSequentialGroup()
                        .addGap(770, 770, 770)
                        .addComponent(jLabel71))
                    .addGroup(programmeLayout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        programmeLayout.setVerticalGroup(
            programmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(programmeLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(jLabel71)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        Parent.add(programme, "programme");

        addProgramme.setBackground(new java.awt.Color(102, 51, 109));

        jPanel22.setBackground(new java.awt.Color(137, 14, 137));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Start Year and Semester");
        jPanel22.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 147, -1, -1));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Programme");
        jPanel22.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 71, -1, -1));

        jButton11.setText("Save");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel22.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 99, 41));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select..." }));
        jComboBox1.setOpaque(false);
        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeVisible(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel22.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 146, 340, 36));

        jTextField3.setBorder(null);
        jTextField3.setOpaque(false);
        jPanel22.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 75, 320, 30));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("End Year and Semester");
        jPanel22.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 230, -1, -1));

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select..." }));
        jComboBox2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox2PopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel22.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 229, 340, 36));

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png"))); // NOI18N
        jPanel22.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 71, -1, -1));

        jPanel9.setBackground(new java.awt.Color(135, 19, 135));

        jLabel80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-50.png"))); // NOI18N
        jLabel80.setToolTipText("");
        jLabel80.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel80MouseClicked(evt);
            }
        });

        jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("Add New Programme");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel80)
                .addGap(568, 568, 568)
                .addComponent(jLabel72)
                .addContainerGap(727, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel80))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout addProgrammeLayout = new javax.swing.GroupLayout(addProgramme);
        addProgramme.setLayout(addProgrammeLayout);
        addProgrammeLayout.setHorizontalGroup(
            addProgrammeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addProgrammeLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2718, Short.MAX_VALUE))
            .addGroup(addProgrammeLayout.createSequentialGroup()
                .addGap(408, 408, 408)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addProgrammeLayout.setVerticalGroup(
            addProgrammeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addProgrammeLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        Parent.add(addProgramme, "addProgramme");

        editProgramme.setBackground(new java.awt.Color(102, 51, 109));

        jButton18.setText("Update");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jPanel23.setBackground(new java.awt.Color(137, 14, 137));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Start Year and Semester");
        jPanel23.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Programme");
        jPanel23.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 71, -1, -1));

        jButton12.setText("Update");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel23.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 99, 41));

        jComboBox4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select..." }));
        jComboBox4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox4PopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel23.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 340, 36));

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("End Year and Semester");
        jPanel23.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        jComboBox5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select..." }));
        jComboBox5.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox5PopupMenuWillBecomeVisible(evt);
            }
        });
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        jPanel23.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 340, 36));

        jButton13.setText("Delete");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel23.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 99, 41));

        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField5.setBorder(null);
        jTextField5.setOpaque(false);
        jPanel23.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 73, 320, 30));

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png"))); // NOI18N
        jPanel23.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        jPanel10.setBackground(new java.awt.Color(135, 19, 135));

        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-50.png"))); // NOI18N
        jLabel81.setToolTipText("");
        jLabel81.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel81MouseClicked(evt);
            }
        });

        jLabel82.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setText("Edit Programme");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel81)
                .addGap(561, 561, 561)
                .addComponent(jLabel82)
                .addContainerGap(734, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout editProgrammeLayout = new javax.swing.GroupLayout(editProgramme);
        editProgramme.setLayout(editProgrammeLayout);
        editProgrammeLayout.setHorizontalGroup(
            editProgrammeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editProgrammeLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2793, Short.MAX_VALUE))
            .addGroup(editProgrammeLayout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editProgrammeLayout.setVerticalGroup(
            editProgrammeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editProgrammeLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
        );

        Parent.add(editProgramme, "editProgramme");

        groupNumbers.setBackground(new java.awt.Color(102, 51, 109));
        groupNumbers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Batch", "No of Students", "Groups"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setGridColor(new java.awt.Color(255, 255, 255));
        jTable3.setRowHeight(25);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable3);

        groupNumbers.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 950, 370));

        jTable5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Groups"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.setGridColor(new java.awt.Color(255, 255, 255));
        jTable5.setRowHeight(25);
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable5);

        groupNumbers.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 266, 365, 370));

        jPanel12.setBackground(new java.awt.Color(135, 19, 135));

        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-50.png"))); // NOI18N
        jLabel85.setToolTipText("");
        jLabel85.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel85MouseClicked(evt);
            }
        });

        jLabel86.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setText("Group Numbers");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel85)
                .addGap(586, 586, 586)
                .addComponent(jLabel86)
                .addContainerGap(709, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        groupNumbers.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, -1, -1));

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-75.png"))); // NOI18N
        jLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel47MouseClicked(evt);
            }
        });
        groupNumbers.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(789, 707, -1, -1));

        Parent.add(groupNumbers, "groupNumbers");

        addGroupNumbers.setBackground(new java.awt.Color(102, 51, 109));

        jPanel24.setBackground(new java.awt.Color(137, 14, 137));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Batch");
        jPanel24.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 68, -1, -1));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("No of Students");
        jPanel24.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 155, -1, -1));

        jButton16.setText("Save");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel24.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 357, 99, 41));

        jComboBox3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select..." }));
        jComboBox3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox3PopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel24.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 67, 340, 36));

        jTextField7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField7.setBorder(null);
        jTextField7.setOpaque(false);
        jTextField7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField7FocusLost(evt);
            }
        });
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });
        jPanel24.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 160, 310, 30));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Groups");
        jPanel24.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        jTextField9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField9.setBorder(null);
        jTextField9.setOpaque(false);
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });
        jPanel24.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 243, 320, 30));

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png"))); // NOI18N
        jPanel24.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 155, -1, -1));

        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png"))); // NOI18N
        jPanel24.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 240, -1, -1));

        jPanel13.setBackground(new java.awt.Color(135, 19, 135));

        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-50.png"))); // NOI18N
        jLabel87.setToolTipText("");
        jLabel87.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel87MouseClicked(evt);
            }
        });

        jLabel88.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setText("Add Groups");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel87)
                .addGap(586, 586, 586)
                .addComponent(jLabel88)
                .addContainerGap(709, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel87))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(135, 19, 135));

        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-50.png"))); // NOI18N
        jLabel89.setToolTipText("");
        jLabel89.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel89MouseClicked(evt);
            }
        });

        jLabel90.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setText("Group Numbers");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel89)
                .addGap(586, 586, 586)
                .addComponent(jLabel90)
                .addContainerGap(709, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel89))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout addGroupNumbersLayout = new javax.swing.GroupLayout(addGroupNumbers);
        addGroupNumbers.setLayout(addGroupNumbersLayout);
        addGroupNumbersLayout.setHorizontalGroup(
            addGroupNumbersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addGroupNumbersLayout.createSequentialGroup()
                .addGroup(addGroupNumbersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addGroupNumbersLayout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addGroupNumbersLayout.createSequentialGroup()
                        .addGap(422, 422, 422)
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1194, Short.MAX_VALUE))
        );
        addGroupNumbersLayout.setVerticalGroup(
            addGroupNumbersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addGroupNumbersLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(addGroupNumbersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(134, 134, 134)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        Parent.add(addGroupNumbers, "addGroupNumbers");

        addTags.setBackground(new java.awt.Color(102, 51, 109));

        jPanel25.setBackground(new java.awt.Color(137, 14, 137));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Tag");
        jPanel25.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 107, 61, -1));

        jTextField8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField8.setBorder(null);
        jTextField8.setOpaque(false);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jPanel25.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 110, 320, 30));

        jButton17.setText("Save");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel25.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 252, 99, 41));

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png"))); // NOI18N
        jPanel25.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 107, -1, -1));

        jPanel21.setBackground(new java.awt.Color(135, 19, 135));

        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-50.png"))); // NOI18N
        jLabel91.setToolTipText("");
        jLabel91.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel91MouseClicked(evt);
            }
        });

        jLabel92.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setText("Add Tag");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel91)
                .addGap(621, 621, 621)
                .addComponent(jLabel92)
                .addContainerGap(715, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel91))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout addTagsLayout = new javax.swing.GroupLayout(addTags);
        addTags.setLayout(addTagsLayout);
        addTagsLayout.setHorizontalGroup(
            addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTagsLayout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2861, Short.MAX_VALUE))
            .addGroup(addTagsLayout.createSequentialGroup()
                .addGap(496, 496, 496)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addTagsLayout.setVerticalGroup(
            addTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTagsLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
        );

        Parent.add(addTags, "addTags");

        editGroupNumbers.setBackground(new java.awt.Color(102, 51, 109));

        jPanel27.setBackground(new java.awt.Color(137, 14, 137));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Batch");
        jPanel27.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 68, -1, -1));

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("No of Students");
        jPanel27.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 170, -1, -1));

        jButton19.setText("Update");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel27.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 99, 41));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select..." }));
        jComboBox8.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox8PopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel27.add(jComboBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 67, 340, 36));

        jTextField10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField10.setBorder(null);
        jTextField10.setOpaque(false);
        jTextField10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField10FocusLost(evt);
            }
        });
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField10KeyTyped(evt);
            }
        });
        jPanel27.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 274, 320, 30));

        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Groups");
        jPanel27.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 270, -1, -1));

        jTextField11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField11.setBorder(null);
        jTextField11.setOpaque(false);
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField11KeyTyped(evt);
            }
        });
        jPanel27.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 174, 320, 30));

        jButton20.setText("Delete");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel27.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 400, 99, 41));

        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png"))); // NOI18N
        jPanel27.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 170, -1, -1));

        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png"))); // NOI18N
        jPanel27.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 270, -1, 41));

        jPanel30.setBackground(new java.awt.Color(135, 19, 135));

        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-50.png"))); // NOI18N
        jLabel93.setToolTipText("");
        jLabel93.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel93MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel93MouseEntered(evt);
            }
        });

        jLabel94.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setText("Edit Groups");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel93)
                .addGap(621, 621, 621)
                .addComponent(jLabel94)
                .addContainerGap(715, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel93))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout editGroupNumbersLayout = new javax.swing.GroupLayout(editGroupNumbers);
        editGroupNumbers.setLayout(editGroupNumbersLayout);
        editGroupNumbersLayout.setHorizontalGroup(
            editGroupNumbersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editGroupNumbersLayout.createSequentialGroup()
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2816, Short.MAX_VALUE))
            .addGroup(editGroupNumbersLayout.createSequentialGroup()
                .addGap(429, 429, 429)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editGroupNumbersLayout.setVerticalGroup(
            editGroupNumbersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editGroupNumbersLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        Parent.add(editGroupNumbers, "editGroupNumbers");

        subGroupNumbers.setBackground(new java.awt.Color(102, 51, 109));
        subGroupNumbers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Groups", "No of Subgroups"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable6.setGridColor(new java.awt.Color(255, 255, 255));
        jTable6.setRowHeight(25);
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTable6);

        subGroupNumbers.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 839, 380));

        jTable7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Groups"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable7.setGridColor(new java.awt.Color(255, 255, 255));
        jTable7.setRowHeight(25);
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTable7);

        subGroupNumbers.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 260, 365, 380));

        jPanel31.setBackground(new java.awt.Color(135, 19, 135));

        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-50.png"))); // NOI18N
        jLabel95.setToolTipText("");
        jLabel95.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel95MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel95MouseEntered(evt);
            }
        });

        jLabel96.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setText("Subgroup Numbers");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel95)
                .addGap(526, 526, 526)
                .addComponent(jLabel96)
                .addContainerGap(810, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel95))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        subGroupNumbers.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 42, -1, -1));

        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-75.png"))); // NOI18N
        jLabel97.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel97MouseClicked(evt);
            }
        });
        subGroupNumbers.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 710, -1, -1));

        Parent.add(subGroupNumbers, "subGroupNumbers");

        addSubGroupNumbers.setBackground(new java.awt.Color(102, 51, 109));

        jPanel26.setBackground(new java.awt.Color(137, 14, 137));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Group");
        jPanel26.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 96, -1, -1));

        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("No of Subgroups");
        jPanel26.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 213, -1, -1));

        jButton22.setText("Save");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel26.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 99, 41));

        jComboBox6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select..." }));
        jComboBox6.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox6PopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel26.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 95, 340, 36));

        jTextField12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField12.setBorder(null);
        jTextField12.setOpaque(false);
        jTextField12.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField12FocusLost(evt);
            }
        });
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField12KeyTyped(evt);
            }
        });
        jPanel26.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 217, 320, 30));

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png"))); // NOI18N
        jPanel26.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 213, -1, -1));

        jPanel32.setBackground(new java.awt.Color(135, 19, 135));

        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-50.png"))); // NOI18N
        jLabel98.setToolTipText("");
        jLabel98.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel98MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel98MouseEntered(evt);
            }
        });

        jLabel99.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(255, 255, 255));
        jLabel99.setText("Add Subgroups");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel98)
                .addGap(526, 526, 526)
                .addComponent(jLabel99)
                .addContainerGap(810, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel98))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout addSubGroupNumbersLayout = new javax.swing.GroupLayout(addSubGroupNumbers);
        addSubGroupNumbers.setLayout(addSubGroupNumbersLayout);
        addSubGroupNumbersLayout.setHorizontalGroup(
            addSubGroupNumbersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSubGroupNumbersLayout.createSequentialGroup()
                .addGroup(addSubGroupNumbersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addSubGroupNumbersLayout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(2761, Short.MAX_VALUE))
        );
        addSubGroupNumbersLayout.setVerticalGroup(
            addSubGroupNumbersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSubGroupNumbersLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        Parent.add(addSubGroupNumbers, "addSubGroupNumbers");

        editSubGroupNumbers.setBackground(new java.awt.Color(102, 51, 109));

        jPanel28.setBackground(new java.awt.Color(137, 14, 137));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Group");
        jPanel28.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 96, -1, -1));

        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("No of Subgroups");
        jPanel28.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 213, -1, -1));

        jButton23.setText("Update");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel28.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 99, 41));

        jComboBox7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select..." }));
        jComboBox7.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox7PopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel28.add(jComboBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 95, 340, 36));

        jTextField13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField13.setBorder(null);
        jTextField13.setOpaque(false);
        jTextField13.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField13FocusLost(evt);
            }
        });
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });
        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField13KeyTyped(evt);
            }
        });
        jPanel28.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 217, 320, 30));

        jButton24.setText("Delete");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel28.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, 99, 41));

        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png"))); // NOI18N
        jPanel28.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 213, -1, -1));

        jPanel33.setBackground(new java.awt.Color(135, 19, 135));

        jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-50.png"))); // NOI18N
        jLabel100.setToolTipText("");
        jLabel100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel100MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel100MouseEntered(evt);
            }
        });

        jLabel101.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(255, 255, 255));
        jLabel101.setText("Edit Subgroups");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel100)
                .addGap(526, 526, 526)
                .addComponent(jLabel101)
                .addContainerGap(810, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel100))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout editSubGroupNumbersLayout = new javax.swing.GroupLayout(editSubGroupNumbers);
        editSubGroupNumbers.setLayout(editSubGroupNumbersLayout);
        editSubGroupNumbersLayout.setHorizontalGroup(
            editSubGroupNumbersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editSubGroupNumbersLayout.createSequentialGroup()
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2764, Short.MAX_VALUE))
            .addGroup(editSubGroupNumbersLayout.createSequentialGroup()
                .addGap(391, 391, 391)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editSubGroupNumbersLayout.setVerticalGroup(
            editSubGroupNumbersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editSubGroupNumbersLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        Parent.add(editSubGroupNumbers, "editSubGroupNumbers");

        editTag.setBackground(new java.awt.Color(102, 51, 109));

        jPanel29.setBackground(new java.awt.Color(137, 14, 137));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel68.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Tag");
        jPanel29.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 107, 61, -1));

        jTextField14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField14.setBorder(null);
        jTextField14.setOpaque(false);
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 320, 30));

        jButton25.setText("Update");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel29.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 264, 99, 41));

        jButton26.setText("Delete");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel29.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 264, 99, 41));

        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png"))); // NOI18N
        jPanel29.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 107, 400, -1));

        jPanel34.setBackground(new java.awt.Color(135, 19, 135));

        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-50.png"))); // NOI18N
        jLabel102.setToolTipText("");
        jLabel102.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel102MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel102MouseEntered(evt);
            }
        });

        jLabel103.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(255, 255, 255));
        jLabel103.setText("Edit Tag");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel102)
                .addGap(643, 643, 643)
                .addComponent(jLabel103)
                .addContainerGap(698, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel102))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout editTagLayout = new javax.swing.GroupLayout(editTag);
        editTag.setLayout(editTagLayout);
        editTagLayout.setHorizontalGroup(
            editTagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editTagLayout.createSequentialGroup()
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2859, Short.MAX_VALUE))
            .addGroup(editTagLayout.createSequentialGroup()
                .addGap(499, 499, 499)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editTagLayout.setVerticalGroup(
            editTagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editTagLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );

        Parent.add(editTag, "editTag");

        javax.swing.GroupLayout sessionsPanelLayout = new javax.swing.GroupLayout(sessionsPanel);
        sessionsPanel.setLayout(sessionsPanelLayout);
        sessionsPanelLayout.setHorizontalGroup(
            sessionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4450, Short.MAX_VALUE)
        );
        sessionsPanelLayout.setVerticalGroup(
            sessionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );

        Parent.add(sessionsPanel, "sessionsPanel");

        notAvailableTimes.setBackground(new java.awt.Color(102, 51, 109));

        jPanel37.setBackground(new java.awt.Color(135, 19, 135));

        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-50.png"))); // NOI18N
        jLabel108.setToolTipText("");
        jLabel108.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel108MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel108MouseEntered(evt);
            }
        });

        jLabel109.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(255, 255, 255));
        jLabel109.setText("Not Available Times");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel108)
                .addGap(527, 527, 527)
                .addComponent(jLabel109)
                .addContainerGap(814, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel108))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel38.setBackground(new java.awt.Color(132, 57, 132));
        jPanel38.setPreferredSize(new java.awt.Dimension(283, 322));

        jLabel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/presentation.png"))); // NOI18N

        jLabel111.setFont(new java.awt.Font("Segoe UI Semibold", 2, 24)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(220, 220, 220));
        jLabel111.setText("Lecturers");

        jButton9.setBackground(new java.awt.Color(153, 0, 153));
        jButton9.setForeground(new java.awt.Color(102, 0, 0));
        jButton9.setText(">>>");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(jLabel110)
                .addGap(75, 75, 75))
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel111)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel110)
                .addGap(18, 18, 18)
                .addComponent(jLabel111)
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jPanel39.setBackground(new java.awt.Color(132, 57, 132));

        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/group (2).png"))); // NOI18N

        jLabel113.setFont(new java.awt.Font("Segoe UI Semibold", 2, 24)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(220, 220, 220));
        jLabel113.setText("Groups");

        jButton14.setBackground(new java.awt.Color(153, 0, 153));
        jButton14.setForeground(new java.awt.Color(102, 0, 0));
        jButton14.setText(">>>");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(jLabel112)
                .addGap(75, 75, 75))
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel113))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel112)
                .addGap(18, 18, 18)
                .addComponent(jLabel113)
                .addGap(28, 28, 28)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        jPanel41.setBackground(new java.awt.Color(132, 57, 132));

        jLabel116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/group (1).png"))); // NOI18N

        jLabel117.setFont(new java.awt.Font("Segoe UI Semibold", 2, 24)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(220, 220, 220));
        jLabel117.setText("Subgroups");

        jButton21.setBackground(new java.awt.Color(153, 0, 153));
        jButton21.setForeground(new java.awt.Color(102, 0, 0));
        jButton21.setText(">>>");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(jLabel116)
                .addGap(75, 75, 75))
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel117))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel116)
                .addGap(18, 18, 18)
                .addComponent(jLabel117)
                .addGap(28, 28, 28)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        jPanel42.setBackground(new java.awt.Color(132, 57, 132));
        jPanel42.setPreferredSize(new java.awt.Dimension(283, 322));

        jLabel118.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calendar.png"))); // NOI18N

        jLabel119.setFont(new java.awt.Font("Segoe UI Semibold", 2, 24)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(220, 220, 220));
        jLabel119.setText("Sessions");

        jButton27.setBackground(new java.awt.Color(153, 0, 153));
        jButton27.setForeground(new java.awt.Color(102, 0, 0));
        jButton27.setText(">>>");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel118)
                .addGap(0, 67, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel119))
                .addGap(87, 87, 87))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel118)
                .addGap(18, 18, 18)
                .addComponent(jLabel119)
                .addGap(18, 18, 18)
                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout notAvailableTimesLayout = new javax.swing.GroupLayout(notAvailableTimes);
        notAvailableTimes.setLayout(notAvailableTimesLayout);
        notAvailableTimesLayout.setHorizontalGroup(
            notAvailableTimesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notAvailableTimesLayout.createSequentialGroup()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2692, Short.MAX_VALUE))
            .addGroup(notAvailableTimesLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        notAvailableTimesLayout.setVerticalGroup(
            notAvailableTimesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notAvailableTimesLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171)
                .addGroup(notAvailableTimesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(251, Short.MAX_VALUE))
        );

        Parent.add(notAvailableTimes, "notAvailableTimes");

        notAvailable_lecturers.setBackground(new java.awt.Color(102, 51, 109));

        jPanel40.setBackground(new java.awt.Color(135, 19, 135));

        jLabel114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-50.png"))); // NOI18N
        jLabel114.setToolTipText("");
        jLabel114.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel114MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel114MouseEntered(evt);
            }
        });

        jLabel115.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(255, 255, 255));
        jLabel115.setText("Not Available Times - Lecturers");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel114)
                .addGap(491, 491, 491)
                .addComponent(jLabel115)
                .addContainerGap(850, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel114))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout notAvailable_lecturersLayout = new javax.swing.GroupLayout(notAvailable_lecturers);
        notAvailable_lecturers.setLayout(notAvailable_lecturersLayout);
        notAvailable_lecturersLayout.setHorizontalGroup(
            notAvailable_lecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notAvailable_lecturersLayout.createSequentialGroup()
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2536, Short.MAX_VALUE))
        );
        notAvailable_lecturersLayout.setVerticalGroup(
            notAvailable_lecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notAvailable_lecturersLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(741, Short.MAX_VALUE))
        );

        Parent.add(notAvailable_lecturers, "notAvailable_lecturers");

        notAvailable_session.setBackground(new java.awt.Color(102, 51, 109));

        javax.swing.GroupLayout notAvailable_sessionLayout = new javax.swing.GroupLayout(notAvailable_session);
        notAvailable_session.setLayout(notAvailable_sessionLayout);
        notAvailable_sessionLayout.setHorizontalGroup(
            notAvailable_sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4450, Short.MAX_VALUE)
        );
        notAvailable_sessionLayout.setVerticalGroup(
            notAvailable_sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );

        Parent.add(notAvailable_session, "notAvailable_session");

        settingsPanel.setBackground(new java.awt.Color(102, 51, 109));

        jPanel36.setBackground(new java.awt.Color(132, 57, 132));

        jLabel121.setFont(new java.awt.Font("Segoe UI Semibold", 2, 24)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(220, 220, 220));
        jLabel121.setText("Not Available Times");

        jButton2.setBackground(new java.awt.Color(153, 0, 153));
        jButton2.setForeground(new java.awt.Color(102, 0, 0));
        jButton2.setText(">>>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel67)
                        .addGap(140, 140, 140))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel121)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151))))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel67)
                .addGap(27, 27, 27)
                .addComponent(jLabel121)
                .addGap(28, 28, 28)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(3764, Short.MAX_VALUE))
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(539, Short.MAX_VALUE))
        );

        Parent.add(settingsPanel, "settingsPanel");

        jPanel1.add(Parent, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 116, 4450, 890));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1916, 1000));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void d_btn_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d_btn_1MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_1);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{d_btn_2, d_btn_3, d_btn_4, d_btn_5, d_btn_6, d_btn_7, d_btn_8, d_btn_9, d_btn_10}, new JPanel[]{ind_2, ind_3, ind_4, ind_5, ind_6, ind_7, ind_8, ind_9, ind_10});
        Parent.removeAll();
        Parent.add(studentPanel);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_d_btn_1MouseClicked

    private void d_btn_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d_btn_2MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_2);
        ind_2.setOpaque(true);
        resetColor(new JPanel[]{d_btn_1, d_btn_3, d_btn_4, d_btn_5, d_btn_6, d_btn_7, d_btn_8, d_btn_9, d_btn_10}, new JPanel[]{ind_1, ind_3, ind_4, ind_5, ind_6, ind_7, ind_8, ind_9, ind_10});
        Parent.removeAll();
        Parent.add(new lecturersPanel());
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_d_btn_2MouseClicked

    private void d_btn_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d_btn_3MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_3);
        ind_3.setOpaque(true);
        resetColor(new JPanel[]{d_btn_1, d_btn_2, d_btn_4, d_btn_5, d_btn_6, d_btn_7, d_btn_8, d_btn_9, d_btn_10}, new JPanel[]{ind_1, ind_2, ind_4, ind_5, ind_6, ind_7, ind_8, ind_9, ind_10});
        Parent.removeAll();
        Parent.add(tagsPanel);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_d_btn_3MouseClicked

    private void d_btn_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d_btn_4MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_4);
        ind_4.setOpaque(true);
        resetColor(new JPanel[]{d_btn_1, d_btn_3, d_btn_2, d_btn_5, d_btn_6, d_btn_7, d_btn_8, d_btn_9, d_btn_10}, new JPanel[]{ind_1, ind_3, ind_2, ind_5, ind_6, ind_7, ind_8, ind_9, ind_10});
        Parent.removeAll();
        Parent.add(locationPanel);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_d_btn_4MouseClicked

    private void d_btn_5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d_btn_5MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_5);
        ind_5.setOpaque(true);
        resetColor(new JPanel[]{d_btn_1, d_btn_3, d_btn_4, d_btn_2, d_btn_6, d_btn_7, d_btn_8, d_btn_9, d_btn_10}, new JPanel[]{ind_1, ind_3, ind_4, ind_2, ind_6, ind_7, ind_8, ind_9, ind_10});
        Parent.removeAll();
        Parent.add(workingdaysPanel);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_d_btn_5MouseClicked

    private void d_btn_6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d_btn_6MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_6);
        ind_6.setOpaque(true);
        resetColor(new JPanel[]{d_btn_1, d_btn_3, d_btn_4, d_btn_5, d_btn_2, d_btn_7, d_btn_8, d_btn_9, d_btn_10}, new JPanel[]{ind_1, ind_3, ind_4, ind_5, ind_2, ind_7, ind_8, ind_9, ind_10});
        Parent.removeAll();
        Parent.add(sessionsPanel);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_d_btn_6MouseClicked

    private void d_btn_7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d_btn_7MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_7);
        ind_7.setOpaque(true);
        resetColor(new JPanel[]{d_btn_1, d_btn_3, d_btn_4, d_btn_5, d_btn_6, d_btn_2, d_btn_8, d_btn_9, d_btn_10}, new JPanel[]{ind_1, ind_3, ind_4, ind_5, ind_6, ind_2, ind_8, ind_9, ind_10});
        Parent.removeAll();
        Parent.add(new lec_timetables());
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_d_btn_7MouseClicked

    private void d_btn_8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d_btn_8MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_8);
        ind_8.setOpaque(true);
        resetColor(new JPanel[]{d_btn_1, d_btn_3, d_btn_4, d_btn_5, d_btn_6, d_btn_7, d_btn_2, d_btn_9, d_btn_10}, new JPanel[]{ind_1, ind_3, ind_4, ind_5, ind_6, ind_7, ind_2, ind_9, ind_10});
        Parent.removeAll();
        Parent.add(subjects);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_d_btn_8MouseClicked

    private void d_btn_10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d_btn_10MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_10);
        ind_10.setOpaque(true);
        resetColor(new JPanel[]{d_btn_1, d_btn_3, d_btn_4, d_btn_5, d_btn_6, d_btn_7, d_btn_8, d_btn_9, d_btn_2}, new JPanel[]{ind_1, ind_3, ind_4, ind_5, ind_6, ind_7, ind_8, ind_9, ind_2});
        Parent.removeAll();
        Parent.add(settingsPanel);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_d_btn_10MouseClicked

    private void d_btn_9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d_btn_9MouseClicked
        setColor(d_btn_9);
        ind_9.setOpaque(true);
        resetColor(new JPanel[]{d_btn_1, d_btn_3, d_btn_4, d_btn_5, d_btn_6, d_btn_7, d_btn_8, d_btn_2, d_btn_10}, new JPanel[]{ind_1, ind_3, ind_4, ind_5, ind_6, ind_7, ind_8, ind_2, ind_10});
        Parent.removeAll();
        Parent.add(statsticsPanel);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_d_btn_9MouseClicked

    private void buildNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buildNameActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

        String name = buildName.getText();

        try {
            String query = "SELECT locationID,buildingName,room,capacity,roomType from location where buildingName LIKE '%" + name + "%'";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            locDetails.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_searchActionPerformed

    private void locDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_locDetailsMouseClicked

        int row = locDetails.getSelectedRow();

        ID = locDetails.getValueAt(row, 0).toString();
    }//GEN-LAST:event_locDetailsMouseClicked

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed

        int x = JOptionPane.showConfirmDialog(null, "Do you really want to Delete");

        if (x == 0) {

            try {
                String query = "DELETE from location where locationID = '" + ID + "'";
                pst = con.prepareStatement(query);
                pst.execute();

                LocationtableLoad();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        Parent.removeAll();
        Parent.add(addLocation);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_addActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed

        Parent.removeAll();
        Parent.add(editLocation);
        Parent.repaint();
        Parent.revalidate();


    }//GEN-LAST:event_editActionPerformed

    private void locationMainBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationMainBtnActionPerformed

        Parent.removeAll();
        Parent.add(locationDetails);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_locationMainBtnActionPerformed

    private void addBuildingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBuildingActionPerformed

        String buildname = buildName1.getText();
        ResultSet rs1 = null;

        try {
            //Checking if the buiding is already in the database
            String check = "SELECT Name FROM building Where Name = '" + buildname + "' ";
            pst = con.prepareStatement(check);
            rs1 = pst.executeQuery();

            boolean valid = rs1.next();

            if (valid == false) {
                String q = "INSERT INTO building (Name) values ('" + buildname + "')";
                pst = con.prepareStatement(q);
                pst.execute();

                clear();
            } else {
                JOptionPane.showMessageDialog(null, "This Building already Exists");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_addBuildingActionPerformed

    private void addLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLocActionPerformed

        ResultSet rs1 = null;
        //roomValue structure
        String validRoom = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*";

        String name = buildName1.getText();
        String roomName = room.getText();
        String cap = capacity.getText();
        String roomType = rType.getSelectedItem().toString();

        //Validating room capacity
        boolean capVal = false;
        try {
            Integer.parseInt(cap);
            capVal = true;
        } catch (Exception e) {
            capVal = false;
        }

        if (name.equals("") || roomName.equals("") || cap.equals("") || roomType.equals("Select a Room Type")) {
            JOptionPane.showMessageDialog(null, "All Feilds Must be Filled");
        } else if (!roomName.matches(validRoom)) {
            JOptionPane.showMessageDialog(null, "Invalid Room");
        } else if (capVal == false) {
            JOptionPane.showMessageDialog(null, "Invalid Capacity");
        } else {
            try {
                //Checking if the buiding is a valid buiding
                String check = "SELECT Name FROM building Where Name = '" + name + "' ";
                pst = con.prepareStatement(check);
                rs1 = pst.executeQuery();
                boolean valid = rs1.next();

                if (valid == true) {
                    String q = "INSERT INTO location (buildingName, room, capacity, roomType) values ('" + name + "', '" + roomName + "', '" + cap + "', '" + roomType + "')";
                    pst = con.prepareStatement(q);
                    pst.execute();

                    clear();
                } else {
                    JOptionPane.showMessageDialog(null, "No Such Building");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_addLocActionPerformed

    private void buildName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buildName1ActionPerformed

    private void rTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rTypeActionPerformed

    private void addBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBackActionPerformed

        Parent.removeAll();
        Parent.add(locationDetails);
        Parent.repaint();
        Parent.revalidate();

    }//GEN-LAST:event_addBackActionPerformed

    private void editLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editLocActionPerformed

        ResultSet rs1 = null;
        //roomValue structure
        String validRoom = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*";

        int x = JOptionPane.showConfirmDialog(null, "Do you really want to update");

        String name = buildName2.getText();
        String room = room1.getText();
        String cap = capacity1.getText();
        String type = rType1.getSelectedItem().toString();

        //Validating room capacity
        boolean capVal = false;
        try {
            Integer.parseInt(cap);
            capVal = true;
        } catch (Exception e) {
            capVal = false;
        }

        if (x == 0) {
            if (name.equals("") || room.equals("") || cap.equals("") || type.equals("Select a Room Type")) {
                JOptionPane.showMessageDialog(null, "All Feilds Must be Filled");
            } else if (!room.matches(validRoom)) {
                JOptionPane.showMessageDialog(null, "Invalid Room");
            } else if (capVal == false) {
                JOptionPane.showMessageDialog(null, "Invalid Capacity");
            } else {
                try {
                    //Checking if the buiding is a valid buiding
                    String check = "SELECT Name FROM building Where Name = '" + name + "' ";
                    pst = con.prepareStatement(check);
                    rs1 = pst.executeQuery();
                    boolean valid = rs1.next();

                    if (valid == true) {
                        String query = "UPDATE location SET buildingName='" + name + "', room = '" + room + "', capacity = '" + cap + "', roomType = '" + type + "' where locationID = '" + ID + "'";
                        pst = con.prepareStatement(query);
                        pst.execute();

                        LocationEditTableLoad();
                        clear();
                    } else {
                        JOptionPane.showMessageDialog(null, "No Such Building");
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }
    }//GEN-LAST:event_editLocActionPerformed

    private void delBuildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBuildActionPerformed

        ResultSet rs1 = null;
        String name = sName.getText();

        int x = JOptionPane.showConfirmDialog(null, "Do you really want to Delete Whole building Details? all location details will be deleted");

        if (x == 0) {
            try {
                //Checking if the buiding is a valid buiding
                String check = "SELECT Name FROM building Where Name = '" + name + "' ";
                pst = con.prepareStatement(check);
                rs1 = pst.executeQuery();
                boolean valid = rs1.next();

                if (valid == true) {
                    //Deleting the buiding from the buiding infomation
                    String query = "DELETE from building where Name = '" + name + "'";
                    pst = con.prepareStatement(query);
                    pst.execute();

                    //deleting all the locations related to that building
                    String q2 = "DELETE from location where buildingName = '" + name + "'";
                    pst = con.prepareStatement(q2);
                    pst.execute();

                    LocationtableLoad();
                } else {
                    JOptionPane.showMessageDialog(null, "Such a Buiding Does not Exist to be deleted");
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_delBuildActionPerformed

    private void locationInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_locationInfoMouseClicked

        int row = locationInfo.getSelectedRow();

        ID = locationInfo.getValueAt(row, 0).toString();
        String name = locationInfo.getValueAt(row, 1).toString();
        String sroom = locationInfo.getValueAt(row, 2).toString();
        String cap = locationInfo.getValueAt(row, 3).toString();
        String type = locationInfo.getValueAt(row, 4).toString();

        buildName2.setText(name);
        room1.setText(sroom);
        capacity1.setText(cap);
        rType1.setSelectedItem(type);
    }//GEN-LAST:event_locationInfoMouseClicked

    private void buildName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildName2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buildName2ActionPerformed

    private void editBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBackActionPerformed

        Parent.removeAll();
        Parent.add(locationDetails);
        Parent.repaint();
        Parent.revalidate();

    }//GEN-LAST:event_editBackActionPerformed

    private void searchBuildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBuildActionPerformed

        LocationEditTableLoad();
        String name = sName.getText();

        try {
            String query = "SELECT locationID,buildingName,room,capacity,roomType from location where buildingName LIKE '%" + name + "%'";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            locationInfo.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_searchBuildActionPerformed

    private void studentStatisticDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentStatisticDataActionPerformed

        int res1 = 0;
        int res2 = 0;
        int res3 = 0;
        int res4 = 0;

        //String y = "Y1";
        try {
            String q = "SELECT SUM(NoOfGroups) AS total FROM student where Year LIKE '%" + "Y1" + "%' ";
            pst = con.prepareStatement(q);
            ResultSet c1 = pst.executeQuery();
            c1.next();
            res1 = c1.getInt("total");

            String q1 = "SELECT SUM(NoOfGroups) AS total FROM student where Year LIKE '%" + "Y2" + "%' ";
            pst = con.prepareStatement(q1);
            ResultSet c2 = pst.executeQuery();
            c2.next();
            res2 = c2.getInt("total");

            String q2 = "SELECT SUM(NoOfGroups) AS total FROM student where Year LIKE '%" + "Y3" + "%' ";
            pst = con.prepareStatement(q2);
            ResultSet c3 = pst.executeQuery();
            c3.next();
            res3 = c3.getInt("total");

            String q3 = "SELECT SUM(NoOfGroups) AS total FROM student where Year LIKE '%" + "Y4" + "%' ";
            pst = con.prepareStatement(q3);
            ResultSet c4 = pst.executeQuery();
            c4.next();
            res4 = c4.getInt("total");

        } catch (Exception e) {

        }

        DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        barChartData.setValue(res1, "Student Groups", "1st Year");
        barChartData.setValue(res2, "Student Groups", "2nd Year");
        barChartData.setValue(res3, "Student Groups", "3rd Year");
        barChartData.setValue(res4, "Student Groups", "4th Year");

        JFreeChart barChart = ChartFactory.createBarChart("Data Representation of Students", "Year", "Student Groups", barChartData, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot barChrt = barChart.getCategoryPlot();
        barChrt.setRangeGridlinePaint(Color.BLUE);

        ChartPanel barPanel = new ChartPanel(barChart);
        panelChart.removeAll();
        panelChart.add(barPanel, BorderLayout.CENTER);
        panelChart.validate();

    }//GEN-LAST:event_studentStatisticDataActionPerformed

    private void lecturersStatisticDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturersStatisticDataActionPerformed

        String center1 = "Malabe";
        String center2 = "Metro";
        String center3 = "Kurunagala";
        String center4 = "Kandy";
        String center5 = "Jaffna";
        String center6 = "Matara";

        int res1 = 0;
        int res2 = 0;
        int res3 = 0;
        int res4 = 0;
        int res5 = 0;
        int res6 = 0;
        try {
            String q = "SELECT COUNT(name) AS total FROM lec where Center = '" + center1 + "' ";
            pst = con.prepareStatement(q);
            ResultSet c1 = pst.executeQuery();
            c1.next();
            res1 = c1.getInt("total");

            String q1 = "SELECT COUNT(name) AS total FROM lec where Center = '" + center2 + "' ";
            pst = con.prepareStatement(q1);
            ResultSet c2 = pst.executeQuery();
            c2.next();
            res2 = c2.getInt("total");

            String q2 = "SELECT COUNT(name) AS total FROM lec where Center = '" + center3 + "' ";
            pst = con.prepareStatement(q2);
            ResultSet c3 = pst.executeQuery();
            c3.next();
            res3 = c3.getInt("total");

            String q3 = "SELECT COUNT(name) AS total FROM lec where Center = '" + center4 + "' ";
            pst = con.prepareStatement(q3);
            ResultSet c4 = pst.executeQuery();
            c4.next();
            res4 = c4.getInt("total");

            String q4 = "SELECT COUNT(name) AS total FROM lec where Center = '" + center5 + "' ";
            pst = con.prepareStatement(q4);
            ResultSet c5 = pst.executeQuery();
            c5.next();
            res5 = c5.getInt("total");

            String q5 = "SELECT COUNT(name) AS total FROM lec where Center = '" + center6 + "' ";
            pst = con.prepareStatement(q5);
            ResultSet c6 = pst.executeQuery();
            c6.next();
            res6 = c6.getInt("total");

        } catch (Exception e) {
            System.out.println(e);
        }

        DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        barChartData.setValue(res1, "Lecturers", center1);
        barChartData.setValue(res2, "Lecturers", center2);
        barChartData.setValue(res3, "Lecturers", center3);
        barChartData.setValue(res4, "Lecturers", center4);
        barChartData.setValue(res5, "Lecturers", center5);
        barChartData.setValue(res6, "Lecturers", center6);

        JFreeChart barChart = ChartFactory.createBarChart("Data Representation of Lecturers", "Centers", "Lecturers", barChartData, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot barChrt = barChart.getCategoryPlot();
        barChrt.setRangeGridlinePaint(Color.BLUE);

        ChartPanel barPanel = new ChartPanel(barChart);
        lecturersChrt.removeAll();
        lecturersChrt.add(barPanel, BorderLayout.CENTER);
        lecturersChrt.validate();
    }//GEN-LAST:event_lecturersStatisticDataActionPerformed

    private void subjectsStatisticDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectsStatisticDataActionPerformed

        //int y1 = 1;
        int res1 = 0;
        int res2 = 0;
        int res3 = 0;
        int res4 = 0;
        try {
            String q = "SELECT COUNT(*) AS total FROM subject where year = '" + 1 + "' ";
            pst = con.prepareStatement(q);
            ResultSet c1 = pst.executeQuery();
            c1.next();
            res1 = c1.getInt("total");

            String q1 = "SELECT COUNT(*) AS total FROM subject where year = '" + 2 + "' ";
            pst = con.prepareStatement(q1);
            ResultSet c2 = pst.executeQuery();
            c2.next();
            res2 = c2.getInt("total");

            String q2 = "SELECT COUNT(*) AS total FROM subject where year = '" + 3 + "' ";
            pst = con.prepareStatement(q2);
            ResultSet c3 = pst.executeQuery();
            c3.next();
            res3 = c3.getInt("total");

            String q3 = "SELECT COUNT(*) AS total FROM subject where year = '" + 4 + "' ";
            pst = con.prepareStatement(q3);
            ResultSet c4 = pst.executeQuery();
            c4.next();
            res4 = c4.getInt("total");

        } catch (Exception e) {
            System.out.println(e);
        }

        DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        barChartData.setValue(res1, "Subjects", "1st Year");
        barChartData.setValue(res2, "Subjects", "2nd Year");
        barChartData.setValue(res3, "Subjects", "3rd Year");
        barChartData.setValue(res4, "Subjects", "4th Year");

        JFreeChart barChart = ChartFactory.createBarChart("Data Representation of Subjects", "Year", "Subjects", barChartData, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot barChrt = barChart.getCategoryPlot();
        barChrt.setRangeGridlinePaint(Color.BLUE);

        ChartPanel barPanel = new ChartPanel(barChart);
        subjectChart.removeAll();
        subjectChart.add(barPanel, BorderLayout.CENTER);
        subjectChart.validate();
    }//GEN-LAST:event_subjectsStatisticDataActionPerformed

    private void statisticBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticBtnActionPerformed

        Parent.removeAll();
        Parent.add(dataVisualization);
        Parent.repaint();
        Parent.revalidate();

    }//GEN-LAST:event_statisticBtnActionPerformed

    private void groupAndLecBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupAndLecBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_groupAndLecBtnActionPerformed

    private void reservationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservationBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reservationBtnActionPerformed

    private void alloAndSessionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alloAndSessionBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alloAndSessionBtnActionPerformed

    private void groupAndTagBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupAndTagBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_groupAndTagBtnActionPerformed

    private void add_subsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_subsActionPerformed
        // TODO add your handling code here:

        String codes = sa.getText();
        String names = sa1.getText();
        String years = sa2.getSelectedItem().toString();
        String sems = sa3.getSelectedItem().toString();
        String lecs = sa4.getSelectedItem().toString();
        String tutes = sa5.getSelectedItem().toString();
        String labs = sa6.getSelectedItem().toString();
        String evas = sa7.getSelectedItem().toString();

        try {

            //Check if there are any empty field before adding details to the database
            if (sa.getText().isEmpty() || sa1.getText().isEmpty() || sa2.getSelectedItem().equals("Select Year") || sa3.getSelectedItem().equals("Select Semester") || sa4.getSelectedItem().equals("Select Lecture Hours") || sa5.getSelectedItem().equals("Select Tutorial Hours") || sa6.getSelectedItem().equals("Select Lab Hours") || sa7.getSelectedItem().equals("Select Evaluation Hours")) {

                JOptionPane.showMessageDialog(null, "Invalid Input");

            }

            //add a new subject to the database
            Statement s = con.createStatement();
            s.execute("INSERT INTO subject(code,name,year,sem,lec,tute,lab,eva) values('" + codes + "','" + names + "','" + years + "','" + sems + "','" + lecs + "','" + tutes + "','" + labs + "','" + evas + "')");

            JOptionPane.showMessageDialog(this, "Records Are Submitted!");

            setsubjectTable();
            s.close();
            resetSubData();

        } catch (Exception ex) {

            //            JOptionPane.showMessageDialog(this, ex);
        }

    }//GEN-LAST:event_add_subsActionPerformed

    private void jButton17_17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17_17ActionPerformed
        // TODO add your handling code here:

        Parent.removeAll();
        Parent.add(subjects);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jButton17_17ActionPerformed

    private void saKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_saKeyPressed
        // TODO add your handling code here:

        char c = evt.getKeyChar();
        String code = sa.getText();

        int length = code.length();

        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '4') {

            if (length < 5) {

                lecturer_add.la.setEditable(true);

            } else {

                lecturer_add.la.setEditable(false);

            }

        }

    }//GEN-LAST:event_saKeyPressed

    private void sa1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sa1KeyPressed
        // TODO add your handling code here:

        char c = evt.getKeyChar();

        //check if the textField contains only letters and space
        if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {

            sa1.setEditable(true);

        } else {

            sa1.setEditable(false);
            JOptionPane.showMessageDialog(this, "Enter Only Letters!");

        }

    }//GEN-LAST:event_sa1KeyPressed

    private void sa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sa2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sa2ActionPerformed

    private void edit_subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_subActionPerformed
        // TODO add your handling code here:

        Parent.removeAll();
        Parent.add(subject_edit);
        Parent.repaint();
        Parent.revalidate();

        Function f = new Function();

        ResultSet rs = null;

        String codes = "code";
        String names = "name";
        String years = "year";
        String sems = "sem";
        String lecs = "lec";
        String tutes = "tute";
        String labs = "lab";
        String evas = "eva";

        rs = f.find(sd.getText());

        try {

            if (rs.next()) {

                se.setText(rs.getString("code"));
                se1.setText(rs.getString("name"));
                se2.setSelectedItem(rs.getString("year"));
                se3.setSelectedItem(rs.getString("sem"));
                se4.setSelectedItem(rs.getString("lec"));
                se5.setSelectedItem(rs.getString("tute"));
                se6.setSelectedItem(rs.getString("lab"));
                se7.setSelectedItem(rs.getString("eva"));

            } else {

                JOptionPane.showMessageDialog(null, "Sorry, No Data Found!");

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_edit_subActionPerformed

    private void delete_subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_subActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delete_subActionPerformed

    private void jButton20_20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20_20ActionPerformed
        // TODO add your handling code here:

        Parent.removeAll();
        Parent.add(subjects);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jButton20_20ActionPerformed

    private void delete_subjectdetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_subjectdetailActionPerformed
        // TODO add your handling code here:

        try {

            String codes = sd.getText();

            //delete subject details from database
            Statement s = con.createStatement();
            s.execute("delete from subject where code='" + codes + "'");
            JOptionPane.showMessageDialog(this, "Record Are Deleted!");

            setsubjectTable();
            s.close();
            resetSubData();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this, "Can't Delete Records!");
        }

    }//GEN-LAST:event_delete_subjectdetailActionPerformed

    private void sdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sdActionPerformed

    private void sd1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sd1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_sd1KeyPressed

    private void view_subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_subActionPerformed
        // TODO add your handling code here:

        Function f = new Function();

        ResultSet rs = null;

        String codes = "code";
        String names = "name";
        String years = "year";
        String sems = "sem";
        String lecs = "lec";
        String tutes = "tute";
        String labs = "lab";
        String evas = "eva";

        rs = f.find(sd.getText());

        try {

            //view the details
            if (rs.next()) {

                sd1.setText(rs.getString("name"));
                sd2.setSelectedItem(rs.getString("year"));
                sd3.setSelectedItem(rs.getString("sem"));
                sd4.setSelectedItem(rs.getString("lec"));
                sd5.setSelectedItem(rs.getString("tute"));
                sd6.setSelectedItem(rs.getString("lab"));
                sd7.setSelectedItem(rs.getString("eva"));

            } else {
                JOptionPane.showMessageDialog(null, "Sorry, No Data Found!");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_view_subActionPerformed

    private void update_subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_subActionPerformed
        // TODO add your handling code here:

        String codes = se.getText();
        String names = se1.getText();
        String years = se2.getSelectedItem().toString();
        String sems = se3.getSelectedItem().toString();
        String lecs = se4.getSelectedItem().toString();
        String tutes = se5.getSelectedItem().toString();
        String labs = se6.getSelectedItem().toString();
        String evas = se7.getSelectedItem().toString();

        try {

            //Check if there are any empty field before updating details
            if (se.getText().isEmpty() || se1.getText().isEmpty() || se2.getSelectedItem().equals("Select Year") || se3.getSelectedItem().equals("Select Semester") || se4.getSelectedItem().equals("Select Lecture Hours") || se5.getSelectedItem().equals("Select Tutorial Hours") || se6.getSelectedItem().equals("Select Lab Hours") || se7.getSelectedItem().equals("Select Evaluation Hours")) {

                JOptionPane.showMessageDialog(null, "Invalid Input");

            }

            //update subject details
            Statement s = con.createStatement();
            s.execute("update subject set name='" + names + "',year='" + years + "',sem='" + sems + "',lec ='" + lecs + "',tute='" + tutes + "',lab='" + labs + "',eva='" + evas + "' where code='" + codes + "'");

            JOptionPane.showMessageDialog(this, "Records Are Updated!");

            setsubjectTable();
            s.close();
            resetSubData();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this, "Can't Update Records!");

        }

    }//GEN-LAST:event_update_subActionPerformed

    private void seKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_seKeyPressed
        // TODO add your handling code here:

        char c = evt.getKeyChar();

        if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {

            se.setEditable(true);

        } else {

            se.setEditable(false);

        }

    }//GEN-LAST:event_seKeyPressed

    private void se1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_se1KeyPressed
        // TODO add your handling code here:

        char c = evt.getKeyChar();

        //check if the textField contains only letters and space
        if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {

            se1.setEditable(true);

        } else {

            se1.setEditable(false);
            JOptionPane.showMessageDialog(this, "Enter Only Letters!");

        }

    }//GEN-LAST:event_se1KeyPressed

    private void jButton23_23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23_23ActionPerformed
        // TODO add your handling code here:

        Parent.removeAll();
        Parent.add(subject_detail);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jButton23_23ActionPerformed

    private void subject_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subject_addActionPerformed
        // TODO add your handling code here:

        Parent.removeAll();
        Parent.add(subjects_add);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_subject_addActionPerformed

    private void subject_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subject_detailsActionPerformed
        // TODO add your handling code here:
        Parent.removeAll();
        Parent.add(subject_detail);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_subject_detailsActionPerformed

    private void wds_first_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wds_first_addActionPerformed
        // TODO add your handling code here:
        parent_wds.removeAll();
        parent_wds.add(wds_second);
        parent_wds.repaint();
        parent_wds.revalidate();
    }//GEN-LAST:event_wds_first_addActionPerformed

    private void wds_first_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wds_first_viewActionPerformed
        // TODO add your handling code here:
        parent_wds.removeAll();
        parent_wds.add(wds_third_viewdetails);
        parent_wds.repaint();
        parent_wds.revalidate();
    }//GEN-LAST:event_wds_first_viewActionPerformed

    private void sundayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sundayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sundayActionPerformed

    private void wds_second_add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wds_second_add_btnActionPerformed
        // TODO add your handling code here:

        ArrayList<String> wds = new ArrayList<String>();

        boolean wd1 = monday.isSelected();
        boolean wd2 = tuesday.isSelected();
        boolean wd3 = wednesday.isSelected();
        boolean wd4 = thursday.isSelected();
        boolean wd5 = friday.isSelected();
        boolean wd6 = saturday.isSelected();
        boolean wd7 = sunday.isSelected();

        if (wd1 == true) {
            wds.add("Monday");
        }
        if (wd2 == true) {
            wds.add("Tuesday");
        }
        if (wd3 == true) {
            wds.add("Wednesday");
        }
        if (wd4 == true) {
            wds.add("Thursday");
        }
        if (wd5 == true) {
            wds.add("Friday");
        }
        if (wd6 == true) {
            wds.add("Saturday");
        }
        if (wd7 == true) {
            wds.add("Sunday");
        }

        String tt_type = wds_sec_type.getSelectedItem().toString();
        System.out.println(tt_type);

        String no_days = wds_sec_ndays.getSelectedItem().toString();
        System.out.println(no_days);

        String hrs = wds_sec_hrs.getText();
        System.out.println(hrs);

        String mins = wds_sec_mins.getText();
        System.out.println(mins);

        String plus = hrs + " hours and " + mins + " minutes";
        System.out.println(plus);

        String t_slot = wds_sec_slot.getSelectedItem().toString();
        System.out.println(t_slot);

        System.out.println(wds);

        try {
            //  String q1 = "INSERT INTO workingdetails (timetable_type,no_days,days,w_hrs,w_mnts,time_slot) VALUES ('"+ tt_type +"', '"+ no_days +"', '"+ wds +"', '"+ hrs +"', '"+ mins +"', '"+ t_slot +"')";
            //create the insert query
            String q1 = "INSERT INTO working_details (timetable_type,number_of_days,working_days,w_hrs,w_mnts,working_time,time_slot) VALUES ('" + tt_type + "', '" + no_days + "', '" + wds + "', '" + hrs + "', '" + mins + "', '" + plus + "', '" + t_slot + "')";

            //query to statement
            pst = con.prepareStatement(q1);
            pst.execute();

            //load table
            tableload();

            JOptionPane.showMessageDialog(null, "Data has been saved successfully.");

        } catch (Exception e) {
            System.out.println(e);

            System.out.println("Please select all valid details");
            JOptionPane.showMessageDialog(this, "Please select all the details.");

        }

    }//GEN-LAST:event_wds_second_add_btnActionPerformed

    private void wds_second_view_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wds_second_view_btnActionPerformed
        // TODO add your handling code here:
        parent_wds.removeAll();
        parent_wds.add(wds_third_viewdetails);
        parent_wds.repaint();
        parent_wds.revalidate();
    }//GEN-LAST:event_wds_second_view_btnActionPerformed

    private void wds_second_back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wds_second_back_btnActionPerformed
        // TODO add your handling code here:
        parent_wds.removeAll();
        parent_wds.add(wds_first);
        parent_wds.repaint();
        parent_wds.revalidate();
    }//GEN-LAST:event_wds_second_back_btnActionPerformed

    private void wds_third_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wds_third_tableMouseClicked
        // TODO add your handling code here:

        r = wds_third_table.getSelectedRow();

        System.out.println(r);

        ids = wds_third_table.getValueAt(r, 0).toString();
        System.out.println("***" + ids);
        String a = wds_third_table.getValueAt(r, 1).toString();
        System.out.println("***" + a);
        String b = wds_third_table.getValueAt(r, 2).toString();
        System.out.println("***" + b);

        test.setText(ids);
        wds_fourth_type.setSelectedItem(a);

    }//GEN-LAST:event_wds_third_tableMouseClicked

    private void wds_third_backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wds_third_backbtnActionPerformed
        // TODO add your handling code here:

        parent_wds.removeAll();
        parent_wds.add(wds_second);
        parent_wds.repaint();
        parent_wds.revalidate();
    }//GEN-LAST:event_wds_third_backbtnActionPerformed

    private void wds_third_deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wds_third_deletebtnActionPerformed
        // TODO add your handling code here:

        if (r == 0) {

            //show message
            JOptionPane.showMessageDialog(this, "Please select a rocord.");

        } else {

            int b = JOptionPane.showConfirmDialog(null, "Do you really want to delete this record?");

            if (b == 0) {

                System.out.println("mmmm" + ids);

                try {
                    System.out.println("mmmm" + ids);
                    String sql = "DELETE from working_details where id='" + ids + "'";
                    pst = con.prepareStatement(sql);
                    pst.execute();
                    System.out.println("deleted");
                    tableload();

                } catch (Exception e) {

                    System.out.println(e);
                }
            }
        }
    }//GEN-LAST:event_wds_third_deletebtnActionPerformed

    private void wds_third_editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wds_third_editbtnActionPerformed
        // TODO add your handling code here:

        if (r == 0) {

            //show message
            JOptionPane.showMessageDialog(this, "Please select a rocord.");

        } else {

            parent_wds.removeAll();
            parent_wds.add(wds_fourth_update);
            parent_wds.repaint();
            parent_wds.revalidate();
        }

    }//GEN-LAST:event_wds_third_editbtnActionPerformed

    private void wds_fourth_updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wds_fourth_updatebtnActionPerformed
        // TODO add your handling code here:

        ArrayList<String> wdup = new ArrayList<String>();

        boolean wdup1 = up_monday.isSelected();
        boolean wdup2 = up_tuesday.isSelected();
        boolean wdup3 = up_wednesday.isSelected();
        boolean wdup4 = up_thursday.isSelected();
        boolean wdup5 = up_friday.isSelected();
        boolean wdup6 = up_saturday.isSelected();
        boolean wdup7 = up_sunday.isSelected();

        if (wdup1 == true) {
            wdup.add("Monday");
        }
        if (wdup2 == true) {
            wdup.add("Tuesday");
        }
        if (wdup3 == true) {
            wdup.add("Wednesday");
        }
        if (wdup4 == true) {
            wdup.add("Thursday");
        }
        if (wdup5 == true) {
            wdup.add("Friday");
        }
        if (wdup6 == true) {
            wdup.add("Saturday");
        }
        if (wdup7 == true) {
            wdup.add("Sunday");
        }

        int x = JOptionPane.showConfirmDialog(null, " Do you really want to update?");

        if (x == 0) {
            String id = test.getText();
            System.out.println(id);
            String tt_type = wds_fourth_type.getSelectedItem().toString();
            System.out.println(tt_type);
            String no_days = wds_fourth_ndays.getSelectedItem().toString();
            System.out.println(no_days);
            String hrs = wds_fourth_hrs.getText();
            System.out.println(hrs);
            String mins = wds_fourth_mins.getText();
            System.out.println(mins);
            String plus = hrs + " hours and " + mins + " minutes";
            System.out.println(plus);
            String t_slot = wds_fourth_slot.getSelectedItem().toString();
            System.out.println(t_slot);

            System.out.println(wdup);

            //String sql = "UPDATE working_details SET type = '"+ tt_type +"' , number_of_days = '"+ no_days +"' , working_days = '"+ wds +"' , w_hrs = '"+ hrs +"' , w_mnts = '"+ mins +"' , working_time = '"+ plus +"' , time_slot = '"+ t_slot +"' where id = ''" + id +"";
            try {

                //update the added data
                String sql1 = "UPDATE working_details SET timetable_type = '" + tt_type + "' , number_of_days = '" + no_days + "' , working_days = '" + wdup + "' , w_hrs = '" + hrs + "' , w_mnts = '" + mins + "' , working_time = '" + plus + "' , time_slot = '" + t_slot + "' where id = '" + id + "' ";

                pst = con.prepareStatement(sql1);

                //query execution
                pst.execute();

                tableload();

                JOptionPane.showMessageDialog(null, "Data has been saved successfully.");

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }//GEN-LAST:event_wds_fourth_updatebtnActionPerformed

    private void wds_fourth_backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wds_fourth_backbtnActionPerformed
        // TODO add your handling code here:
        parent_wds.removeAll();
        parent_wds.add(wds_third_viewdetails);
        parent_wds.repaint();
        parent_wds.revalidate();
    }//GEN-LAST:event_wds_fourth_backbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Parent.removeAll();
        Parent.add(academicYear);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        // TODO add your handling code here:
        Parent.removeAll();
        Parent.add(subGroupNumbers);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Parent.removeAll();
        Parent.add(programme);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Parent.removeAll();
        Parent.add(groupNumbers);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel();
            tnum = dtm.getValueAt(jTable4.getSelectedRow(), 0).toString();
            Parent.removeAll();
            Parent.add(editTag);
            Parent.repaint();
            Parent.revalidate();
            setDetailsTag();
        }
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            anum = dtm.getValueAt(jTable1.getSelectedRow(), 0).toString();
            Parent.removeAll();
            Parent.add(editAcademicYear);
            Parent.repaint();
            Parent.revalidate();
            setDetailsAcademic();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased

        // TODO add your handling code here:
        if (jTextField1.getText().length() == 2) {
            jTextField1.setText(jTextField1.getText() + ".");
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped

        // TODO add your handling code here:
        if (jTextField1.getText().length() == 1) {
            if (!(Character.isDigit(evt.getKeyChar()))) {
                evt.consume();
            }
        }
        if (jTextField1.getText().length() == 4) {
            if (!(Character.isDigit(evt.getKeyChar()))) {
                evt.consume();
            }
        }
        if (jTextField1.getText().length() == 5) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (validateInputAddAcademic()) {
            try {
                DBConnect.iud("INSERT INTO academic VALUES('" + id1 + "','" + jTextField1.getText() + "','" + jTextArea1.getText() + "')");
                JOptionPane.showMessageDialog(this, "Data Saved", "Details added successfully", JOptionPane.INFORMATION_MESSAGE);
                loadDataAcademic();
                jTextField1.setText("");
                Parent.removeAll();
                Parent.add(academicYear);
                Parent.repaint();
                Parent.revalidate();

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Data Not Saved", "Details Not successfully", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Data Not Saved", "Details not added successfully", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased

        // TODO add your handling code here:
        if (jTextField2.getText().length() == 2) {
            jTextField2.setText(jTextField2.getText() + ".");
        }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
        if (jTextField1.getText().length() == 1) {
            if (!(Character.isDigit(evt.getKeyChar()))) {
                evt.consume();
            }
        }
        if (jTextField1.getText().length() == 4) {
            if (!(Character.isDigit(evt.getKeyChar()))) {
                evt.consume();
            }
        }
        if (jTextField1.getText().length() == 5) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            String qry = "UPDATE academic SET academic.year ='" + jTextField2.getText() + "' , academic.description = '" + jTextField4.getText() + "' WHERE id = '" + anum + "'";
            DBConnect.iud(qry);
            JOptionPane.showMessageDialog(this, "Update Successful", "Updated Successfully", JOptionPane.INFORMATION_MESSAGE);
            loadDataAcademic();
            Parent.removeAll();
            Parent.add(academicYear);
            Parent.repaint();
            Parent.revalidate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Updating !!!", "Eror While Updating", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        try {
            String qry = "DELETE FROM academic WHERE academic.id = '" + anum + "' ";
            DBConnect.iud(qry);
            int des = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete Record", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (des == 0) {
                JOptionPane.showMessageDialog(this, "Deleted Record", "Deleted Successfully", JOptionPane.INFORMATION_MESSAGE);
                loadDataAcademic();
                Parent.removeAll();
                Parent.add(academicYear);
                Parent.repaint();
                Parent.revalidate();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Deleting !!!", "Eror While Deleting", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            pnum = dtm.getValueAt(jTable2.getSelectedRow(), 0).toString();
            Parent.removeAll();
            Parent.add(editProgramme);
            Parent.repaint();
            Parent.revalidate();
            setDetailsProgramme();
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        if (validateInputAddProgramme()) {
            try {
                DBConnect.iud("INSERT INTO programme VALUES('" + id2 + "','" + jTextField3.getText() + "','" + jComboBox1.getSelectedItem().toString() + "','" + jComboBox2.getSelectedItem().toString() + "')");
                JOptionPane.showMessageDialog(this, "Data Saved", "Details added successfully", JOptionPane.INFORMATION_MESSAGE);
                jTextField3.setText("");
                loadCombo();
                loadDataProgramme();
                Parent.removeAll();
                Parent.add(programme);
                Parent.repaint();
                Parent.revalidate();

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Data Not Saved", "Details Not successfully", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Data Not Saved", "Details not added successfully", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jComboBox1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeVisible
        // TODO add your handling code here:
        if ("Select...".equals(jComboBox1.getItemAt(0))) {
            jComboBox1.removeItemAt(0);
        }
        if ("Select...".equals(jComboBox1.getItemAt(jComboBox1.getItemCount() - 1))) {
            jComboBox1.removeItemAt(jComboBox1.getItemCount() - 1);
        }
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeVisible

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox2PopupMenuWillBecomeVisible
        // TODO add your handling code here:
        if ("Select...".equals(jComboBox2.getItemAt(0))) {
            jComboBox2.removeItemAt(0);
        }
        if ("Select...".equals(jComboBox2.getItemAt(jComboBox2.getItemCount() - 1))) {
            jComboBox2.removeItemAt(jComboBox2.getItemCount() - 1);
        }
    }//GEN-LAST:event_jComboBox2PopupMenuWillBecomeVisible

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        try {
            String qry = "UPDATE programme SET programme.programme ='" + jTextField5.getText() + "' , programme.start_year = '" + jComboBox4.getSelectedItem().toString() + "', programme.end_year = '" + jComboBox5.getSelectedItem().toString() + "' WHERE id = '" + pnum + "'";
            DBConnect.iud(qry);
            JOptionPane.showMessageDialog(this, "Update Successful", "Updated Successfully", JOptionPane.INFORMATION_MESSAGE);
            loadDataProgramme();
            Parent.removeAll();
            Parent.add(programme);
            Parent.repaint();
            Parent.revalidate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Updating !!!", "Eror While Updating", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jComboBox4PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox4PopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4PopupMenuWillBecomeVisible

    private void jComboBox5PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox5PopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5PopupMenuWillBecomeVisible

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        try {
            String qry = "DELETE FROM programme WHERE programme.id = '" + pnum + "' ";
            DBConnect.iud(qry);
            int des = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete Record", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (des == 0) {
                JOptionPane.showMessageDialog(this, "Deleted Record", "Deleted Successfully", JOptionPane.INFORMATION_MESSAGE);
                loadDataProgramme();
                Parent.removeAll();
                Parent.add(programme);
                Parent.repaint();
                Parent.revalidate();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Deleting !!!", "Eror While Deleting", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
            dnum = dtm.getValueAt(jTable3.getSelectedRow(), 0).toString();
            Parent.removeAll();
            Parent.add(editGroupNumbers);
            Parent.repaint();
            Parent.revalidate();
            setDetailsGroup();
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable5MouseClicked

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        if (validateInputAddGroup()) {
            try {
                DBConnect.iud("INSERT INTO groups VALUES('" + id3 + "','" + jComboBox3.getSelectedItem().toString() + "','" + jTextField7.getText() + "','" + jTextField9.getText() + "')");
                JOptionPane.showMessageDialog(this, "Data Saved", "Details added successfully", JOptionPane.INFORMATION_MESSAGE);
                jTextField7.setText("");
                jTextField9.setText("");
                loadCombo1();
                loadDataGroup();
                setTableGroup();
                Parent.removeAll();
                Parent.add(groupNumbers);
                Parent.repaint();
                Parent.revalidate();

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Data Not Saved", "Details Not successfully", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Data Not Saved", "Details not added successfully", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jComboBox3PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox3PopupMenuWillBecomeVisible
        // TODO add your handling code here:
        if ("Select...".equals(jComboBox3.getItemAt(0))) {
            jComboBox3.removeItemAt(0);
        }
        if ("Select...".equals(jComboBox3.getItemAt(jComboBox3.getItemCount() - 1))) {
            jComboBox3.removeItemAt(jComboBox3.getItemCount() - 1);
        }
    }//GEN-LAST:event_jComboBox3PopupMenuWillBecomeVisible

    private void jTextField7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusLost
        // TODO add your handling code here:

        int value = Integer.parseInt(jTextField7.getText());

        if (value % 120 == 0) {
            jTextField9.setText(String.valueOf(value / 120));
        } else {
            jTextField9.setText(String.valueOf((value / 120) + 1));
        }
    }//GEN-LAST:event_jTextField7FocusLost

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
        int value = Integer.parseInt(jTextField7.getText());

        if (value % 120 == 0) {
            jTextField9.setText(String.valueOf(value / 120));
        } else {
            jTextField9.setText(String.valueOf((value / 120) + 1));
        }
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        // TODO add your handling code here:
        if (!(Character.isDigit(evt.getKeyChar()))) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField7KeyTyped

    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
        // TODO add your handling code here:
        if (!(Character.isDigit(evt.getKeyChar()))) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField9KeyTyped

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        try {
            DBConnect.iud("INSERT INTO tag VALUES('" + id5 + "','" + jTextField8.getText() + "')");
            JOptionPane.showMessageDialog(this, "Data Saved", "Details added successfully", JOptionPane.INFORMATION_MESSAGE);
            jTextField8.setText("");
            loadDataTag();
            Parent.removeAll();
            Parent.add(tagsPanel);
            Parent.repaint();
            Parent.revalidate();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Data Not Saved", "Details Not successfully", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        try {
            String qry = "UPDATE groups SET  groups.batch='" + jComboBox8.getSelectedItem().toString() + "' , groups.students = '" + jTextField10.getText() + "', groups.groups = '" + jTextField11.getText() + "' WHERE id = '" + dnum + "'";
            DBConnect.iud(qry);
            JOptionPane.showMessageDialog(this, "Update Successful", "Updated Successfully", JOptionPane.INFORMATION_MESSAGE);
            loadDataGroup();
            setTableGroup();
            Parent.removeAll();
            Parent.add(groupNumbers);
            Parent.repaint();
            Parent.revalidate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Updating !!!", "Eror While Updating", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jComboBox8PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox8PopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox8PopupMenuWillBecomeVisible

    private void jTextField10FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField10FocusLost
        // TODO add your handling code here:
        int value = Integer.parseInt(jTextField10.getText());

        if (value % 120 == 0) {
            jTextField11.setText(String.valueOf(value / 120));
        } else {
            jTextField11.setText(String.valueOf((value / 120) + 1));
        }
    }//GEN-LAST:event_jTextField10FocusLost

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
        int value = Integer.parseInt(jTextField10.getText());

        if (value % 120 == 0) {
            jTextField11.setText(String.valueOf(value / 120));
        } else {
            jTextField11.setText(String.valueOf((value / 120) + 1));
        }
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyTyped
        // TODO add your handling code here:
        if (!(Character.isDigit(evt.getKeyChar()))) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField10KeyTyped

    private void jTextField11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyTyped
        // TODO add your handling code here:
        if (!(Character.isDigit(evt.getKeyChar()))) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField11KeyTyped

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed

        // TODO add your handling code here:
        try {
            String qry = "DELETE FROM groups WHERE groups.id = '" + dnum + "' ";
            DBConnect.iud(qry);
            int des = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete Record", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (des == 0) {
                JOptionPane.showMessageDialog(this, "Deleted Record", "Deleted Successfully", JOptionPane.INFORMATION_MESSAGE);
                loadDataGroup();
                setTableGroup();
                Parent.removeAll();
                Parent.add(groupNumbers);
                Parent.repaint();
                Parent.revalidate();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Deleting !!!", "Eror While Deleting", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            DefaultTableModel dtm = (DefaultTableModel) jTable6.getModel();
            snum = dtm.getValueAt(jTable6.getSelectedRow(), 0).toString();
            Parent.removeAll();
            Parent.add(editSubGroupNumbers);
            Parent.repaint();
            Parent.revalidate();
            setDetailsSubGroup();

        }
    }//GEN-LAST:event_jTable6MouseClicked

    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable7MouseClicked

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        if (validateInputAddSubGroup()) {
            try {
                DBConnect.iud("INSERT INTO subgroup VALUES('" + id4 + "','" + jComboBox6.getSelectedItem().toString() + "','" + jTextField12.getText() + "')");
                JOptionPane.showMessageDialog(this, "Data Saved", "Details added successfully", JOptionPane.INFORMATION_MESSAGE);
                jTextField12.setText("");
                loadCombo2();
                loadDataSubGroup();
                setTableSubGroup();
                Parent.removeAll();
                Parent.add(subGroupNumbers);
                Parent.repaint();
                Parent.revalidate();

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Data Not Saved", "Details Not successfully", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Data Not Saved", "Details not added successfully", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jComboBox6PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox6PopupMenuWillBecomeVisible
        // TODO add your handling code here:
        if ("Select...".equals(jComboBox6.getItemAt(0))) {
            jComboBox6.removeItemAt(0);
        }
        if ("Select...".equals(jComboBox6.getItemAt(jComboBox6.getItemCount() - 1))) {
            jComboBox6.removeItemAt(jComboBox6.getItemCount() - 1);
        }
    }//GEN-LAST:event_jComboBox6PopupMenuWillBecomeVisible

    private void jTextField12FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField12FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12FocusLost

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyTyped
        // TODO add your handling code here:
        if (!(Character.isDigit(evt.getKeyChar()))) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField12KeyTyped

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        try {
            String qry = "UPDATE subgroup SET  subgroup.group='" + jComboBox7.getSelectedItem().toString() + "' , subgroup.sub_group = '" + jTextField13.getText() + "' WHERE id = '" + snum + "'";
            DBConnect.iud(qry);
            JOptionPane.showMessageDialog(this, "Update Successful", "Updated Successfully", JOptionPane.INFORMATION_MESSAGE);
            loadDataSubGroup();
            setTableSubGroup();
            Parent.removeAll();
            Parent.add(subGroupNumbers);
            Parent.repaint();
            Parent.revalidate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Updating !!!", "Eror While Updating", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jComboBox7PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox7PopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox7PopupMenuWillBecomeVisible

    private void jTextField13FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField13FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13FocusLost

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jTextField13KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyTyped
        // TODO add your handling code here:
        if (!(Character.isDigit(evt.getKeyChar()))) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField13KeyTyped

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        try {
            String qry = "DELETE FROM subgroup WHERE subgroup.id = '" + snum + "' ";
            DBConnect.iud(qry);
            int des = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete Record", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (des == 0) {
                JOptionPane.showMessageDialog(this, "Deleted Record", "Deleted Successfully", JOptionPane.INFORMATION_MESSAGE);
                loadDataSubGroup();
                setTableSubGroup();
                Parent.removeAll();
                Parent.add(subGroupNumbers);
                Parent.repaint();
                Parent.revalidate();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Deleting !!!", "Eror While Deleting", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        try {
            String qry = "UPDATE tag SET  tag.tag='" + jTextField14.getText() + "' WHERE id = '" + tnum + "'";
            DBConnect.iud(qry);
            JOptionPane.showMessageDialog(this, "Update Successful", "Updated Successfully", JOptionPane.INFORMATION_MESSAGE);
            loadDataTag();
            Parent.removeAll();
            Parent.add(tagsPanel);
            Parent.repaint();
            Parent.revalidate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Updating !!!", "Eror While Updating", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        try {
            String qry = "DELETE FROM tag WHERE tag.id = '" + tnum + "' ";
            DBConnect.iud(qry);
            int des = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete Record", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (des == 0) {
                JOptionPane.showMessageDialog(this, "Deleted Record", "Deleted Successfully", JOptionPane.INFORMATION_MESSAGE);
                loadDataTag();
                Parent.removeAll();
                Parent.add(tagsPanel);
                Parent.repaint();
                Parent.revalidate();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Deleting !!!", "Eror While Deleting", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void d_btn_1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d_btn_1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_d_btn_1MousePressed

    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel42MouseClicked

    private void jLabel69MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel69MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_1);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{d_btn_2, d_btn_3, d_btn_4, d_btn_5, d_btn_6, d_btn_7, d_btn_8, d_btn_9, d_btn_10}, new JPanel[]{ind_2, ind_3, ind_4, ind_5, ind_6, ind_7, ind_8, ind_9, ind_10});
        Parent.removeAll();
        Parent.add(studentPanel);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jLabel69MouseClicked

    private void jLabel70MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel70MouseClicked
        // TODO add your handling code here:
        Parent.removeAll();
        Parent.add(addAcademicYear);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jLabel70MouseClicked

    private void jLabel74MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel74MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_1);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{d_btn_2, d_btn_3, d_btn_4, d_btn_5, d_btn_6, d_btn_7, d_btn_8, d_btn_9, d_btn_10}, new JPanel[]{ind_2, ind_3, ind_4, ind_5, ind_6, ind_7, ind_8, ind_9, ind_10});
        Parent.removeAll();
        Parent.add(academicYear);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jLabel74MouseClicked

    private void jLabel75MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel75MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_1);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{d_btn_2, d_btn_3, d_btn_4, d_btn_5, d_btn_6, d_btn_7, d_btn_8, d_btn_9, d_btn_10}, new JPanel[]{ind_2, ind_3, ind_4, ind_5, ind_6, ind_7, ind_8, ind_9, ind_10});
        Parent.removeAll();
        Parent.add(academicYear);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jLabel75MouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jLabel79MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel79MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_1);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{d_btn_2, d_btn_3, d_btn_4, d_btn_5, d_btn_6, d_btn_7, d_btn_8, d_btn_9, d_btn_10}, new JPanel[]{ind_2, ind_3, ind_4, ind_5, ind_6, ind_7, ind_8, ind_9, ind_10});
        Parent.removeAll();
        Parent.add(studentPanel);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jLabel79MouseClicked

    private void jLabel71MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel71MouseClicked
        // TODO add your handling code here:
        Parent.removeAll();
        Parent.add(addProgramme);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jLabel71MouseClicked

    private void jLabel80MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel80MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_1);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{d_btn_2, d_btn_3, d_btn_4, d_btn_5, d_btn_6, d_btn_7, d_btn_8, d_btn_9, d_btn_10}, new JPanel[]{ind_2, ind_3, ind_4, ind_5, ind_6, ind_7, ind_8, ind_9, ind_10});
        Parent.removeAll();
        Parent.add(programme);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jLabel80MouseClicked

    private void jLabel81MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel81MouseClicked
        // TODO add your handling code here:x
        setColor(d_btn_1);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{d_btn_2, d_btn_3, d_btn_4, d_btn_5, d_btn_6, d_btn_7, d_btn_8, d_btn_9, d_btn_10}, new JPanel[]{ind_2, ind_3, ind_4, ind_5, ind_6, ind_7, ind_8, ind_9, ind_10});
        Parent.removeAll();
        Parent.add(programme);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jLabel81MouseClicked

    private void jLabel85MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel85MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_1);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{d_btn_2, d_btn_3, d_btn_4, d_btn_5, d_btn_6, d_btn_7, d_btn_8, d_btn_9, d_btn_10}, new JPanel[]{ind_2, ind_3, ind_4, ind_5, ind_6, ind_7, ind_8, ind_9, ind_10});
        Parent.removeAll();
        Parent.add(studentPanel);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jLabel85MouseClicked

    private void jLabel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseClicked
        // TODO add your handling code here:
        Parent.removeAll();
        Parent.add(addGroupNumbers);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jLabel47MouseClicked

    private void jLabel87MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel87MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_1);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{d_btn_2, d_btn_3, d_btn_4, d_btn_5, d_btn_6, d_btn_7, d_btn_8, d_btn_9, d_btn_10}, new JPanel[]{ind_2, ind_3, ind_4, ind_5, ind_6, ind_7, ind_8, ind_9, ind_10});
        Parent.removeAll();
        Parent.add(groupNumbers);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jLabel87MouseClicked

    private void jLabel89MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel89MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel89MouseClicked

    private void jLabel91MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel91MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_3);
        ind_3.setOpaque(true);
        resetColor(new JPanel[]{d_btn_1, d_btn_2, d_btn_4, d_btn_5, d_btn_6, d_btn_7, d_btn_8, d_btn_9, d_btn_10}, new JPanel[]{ind_1, ind_2, ind_4, ind_5, ind_6, ind_7, ind_8, ind_9, ind_10});
        Parent.removeAll();
        Parent.add(tagsPanel);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jLabel91MouseClicked

    private void jLabel93MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel93MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_1);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{d_btn_2, d_btn_3, d_btn_4, d_btn_5, d_btn_6, d_btn_7, d_btn_8, d_btn_9, d_btn_10}, new JPanel[]{ind_2, ind_3, ind_4, ind_5, ind_6, ind_7, ind_8, ind_9, ind_10});
        Parent.removeAll();
        Parent.add(groupNumbers);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jLabel93MouseClicked

    private void jLabel93MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel93MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel93MouseEntered

    private void jLabel95MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel95MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_1);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{d_btn_2, d_btn_3, d_btn_4, d_btn_5, d_btn_6, d_btn_7, d_btn_8, d_btn_9, d_btn_10}, new JPanel[]{ind_2, ind_3, ind_4, ind_5, ind_6, ind_7, ind_8, ind_9, ind_10});
        Parent.removeAll();
        Parent.add(studentPanel);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jLabel95MouseClicked

    private void jLabel95MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel95MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel95MouseEntered

    private void jLabel97MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel97MouseClicked
        // TODO add your handling code here:
        Parent.removeAll();
        Parent.add(addSubGroupNumbers);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jLabel97MouseClicked

    private void jLabel98MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel98MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_1);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{d_btn_2, d_btn_3, d_btn_4, d_btn_5, d_btn_6, d_btn_7, d_btn_8, d_btn_9, d_btn_10}, new JPanel[]{ind_2, ind_3, ind_4, ind_5, ind_6, ind_7, ind_8, ind_9, ind_10});
        Parent.removeAll();
        Parent.add(subGroupNumbers);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jLabel98MouseClicked

    private void jLabel98MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel98MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel98MouseEntered

    private void jLabel100MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel100MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_1);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{d_btn_2, d_btn_3, d_btn_4, d_btn_5, d_btn_6, d_btn_7, d_btn_8, d_btn_9, d_btn_10}, new JPanel[]{ind_2, ind_3, ind_4, ind_5, ind_6, ind_7, ind_8, ind_9, ind_10});
        Parent.removeAll();
        Parent.add(subGroupNumbers);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jLabel100MouseClicked

    private void jLabel100MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel100MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel100MouseEntered

    private void jLabel102MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel102MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_3);
        ind_3.setOpaque(true);
        resetColor(new JPanel[]{d_btn_1, d_btn_2, d_btn_4, d_btn_5, d_btn_6, d_btn_7, d_btn_8, d_btn_9, d_btn_10}, new JPanel[]{ind_1, ind_2, ind_4, ind_5, ind_6, ind_7, ind_8, ind_9, ind_10});
        Parent.removeAll();
        Parent.add(tagsPanel);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jLabel102MouseClicked

    private void jLabel102MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel102MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel102MouseEntered

    private void jLabel51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseClicked
        // TODO add your handling code here:
        Parent.removeAll();
        Parent.add(addTags);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jLabel51MouseClicked

    private void jLabel108MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel108MouseClicked
        // TODO add your handling code here:
        setColor(d_btn_10);
        ind_10.setOpaque(true);
        resetColor(new JPanel[]{d_btn_1, d_btn_3, d_btn_4, d_btn_5, d_btn_6, d_btn_7, d_btn_8, d_btn_9, d_btn_2}, new JPanel[]{ind_1, ind_3, ind_4, ind_5, ind_6, ind_7, ind_8, ind_9, ind_2});
        Parent.removeAll();
        Parent.add(settingsPanel);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jLabel108MouseClicked

    private void jLabel108MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel108MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel108MouseEntered

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        setColor(d_btn_10);
        ind_10.setOpaque(true);
        resetColor(new JPanel[]{d_btn_1, d_btn_3, d_btn_4, d_btn_5, d_btn_6, d_btn_7, d_btn_8, d_btn_9, d_btn_2}, new JPanel[]{ind_1, ind_3, ind_4, ind_5, ind_6, ind_7, ind_8, ind_9, ind_2});
        Parent.removeAll();
        Parent.add(notAvailable_lecturers);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jLabel114MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel114MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel114MouseClicked

    private void jLabel114MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel114MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel114MouseEntered

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Parent.removeAll();
        Parent.add(notAvailableTimes);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tuesdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuesdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tuesdayActionPerformed

    private void wds_fourth_hrsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wds_fourth_hrsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wds_fourth_hrsActionPerformed

    private void wds_fourth_ndaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wds_fourth_ndaysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wds_fourth_ndaysActionPerformed

    private void up_fridayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up_fridayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_up_fridayActionPerformed

    private void up_tuesdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up_tuesdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_up_tuesdayActionPerformed

    private void up_saturdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up_saturdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_up_saturdayActionPerformed

    private void wds_fourth_minsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wds_fourth_minsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wds_fourth_minsActionPerformed

    private void wds_fourth_slotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wds_fourth_slotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wds_fourth_slotActionPerformed

    public class Function {

        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        public ResultSet find(String s) {

            try {

                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/timetable", "root", "123");
                ps = con.prepareStatement("select * from subject where code=?");
                ps.setString(1, s);
                rs = ps.executeQuery();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

            return rs;

        }

    }

    public class Functionlec {

        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        public ResultSet find(String s) {

            try {

                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/timetable", "root", "123");
                ps = con.prepareStatement("select * from lec where empID=?");
                ps.setString(1, s);
                rs = ps.executeQuery();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

            return rs;

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Generator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Generator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Generator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Generator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Generator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddLocationDetTitle;
    private javax.swing.JButton Delete;
    private javax.swing.JLabel EditBuildLabel;
    private javax.swing.JScrollPane EditLocationDetailScriollPane;
    private javax.swing.JLabel LocationMainBtnImgLabel;
    private javax.swing.JLabel LocationMainBtnLabel;
    public static javax.swing.JPanel Parent;
    private javax.swing.JPanel Visualization_Panel;
    private javax.swing.JPanel academicYear;
    private javax.swing.JButton add;
    private javax.swing.JPanel addAcademicYear;
    private javax.swing.JButton addBack;
    private javax.swing.JButton addBuilding;
    private javax.swing.JLabel addBuildingNameLabel;
    private javax.swing.JPanel addGroupNumbers;
    private javax.swing.JButton addLoc;
    private javax.swing.JPanel addLocation;
    private javax.swing.JPanel addProgramme;
    private javax.swing.JPanel addSubGroupNumbers;
    private javax.swing.JPanel addTags;
    private javax.swing.JButton add_subs;
    private javax.swing.JButton alloAndSessionBtn;
    private javax.swing.JLabel allo_and_session_iconLabel;
    private javax.swing.JLabel allo_and_session_label;
    private javax.swing.JTextField buildName;
    private javax.swing.JTextField buildName1;
    private javax.swing.JTextField buildName2;
    private javax.swing.JLabel buildingNameLabel;
    private javax.swing.JTextField capacity;
    private javax.swing.JTextField capacity1;
    private javax.swing.JLabel capacityEditLabel;
    private javax.swing.JLabel capacityLabel;
    private javax.swing.JPanel d_btn_1;
    private javax.swing.JPanel d_btn_10;
    private javax.swing.JPanel d_btn_2;
    private javax.swing.JPanel d_btn_3;
    private javax.swing.JPanel d_btn_4;
    private javax.swing.JPanel d_btn_5;
    private javax.swing.JPanel d_btn_6;
    private javax.swing.JPanel d_btn_7;
    private javax.swing.JPanel d_btn_8;
    private javax.swing.JPanel d_btn_9;
    private javax.swing.JPanel dataVisualization;
    private javax.swing.JPanel data_visualization;
    private javax.swing.JButton delBuild;
    private javax.swing.JButton delete_sub;
    private javax.swing.JButton delete_subjectdetail;
    private javax.swing.JButton edit;
    private javax.swing.JPanel editAcademicYear;
    private javax.swing.JButton editBack;
    private javax.swing.JPanel editGroupNumbers;
    private javax.swing.JButton editLoc;
    private javax.swing.JLabel editLocSubTitle;
    private javax.swing.JPanel editLocation;
    private javax.swing.JLabel editLocationDetTitle;
    private javax.swing.JPanel editProgramme;
    private javax.swing.JPanel editSubGroupNumbers;
    private javax.swing.JPanel editTag;
    private javax.swing.JButton edit_sub;
    private javax.swing.JCheckBox friday;
    private javax.swing.JButton groupAndLecBtn;
    private javax.swing.JButton groupAndTagBtn;
    private javax.swing.JLabel groupLecLabel;
    private javax.swing.JLabel groupLecLabelIcon;
    private javax.swing.JPanel groupNumbers;
    private javax.swing.JPanel group_lecturers;
    private javax.swing.JPanel ind_1;
    private javax.swing.JPanel ind_10;
    private javax.swing.JPanel ind_2;
    private javax.swing.JPanel ind_3;
    private javax.swing.JPanel ind_4;
    private javax.swing.JPanel ind_5;
    private javax.swing.JPanel ind_6;
    private javax.swing.JPanel ind_7;
    private javax.swing.JPanel ind_8;
    private javax.swing.JPanel ind_9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton17_17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton20_20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton23_23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel100_100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel101_101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel102_102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel103_103;
    private javax.swing.JLabel jLabel104_104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel105_105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107_107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel108_108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel109_109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel110_110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel111_111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel112_112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel113_113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel114_114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel115_115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel116_116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel117_117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel118_118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel119_119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120_120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel121_121;
    private javax.swing.JLabel jLabel122_122;
    private javax.swing.JLabel jLabel123_123;
    private javax.swing.JLabel jLabel124_124;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel28_28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel29_29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel30_30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel79_79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel80_80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel81_81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel82_82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel90_90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel91_91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel92_92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel93_93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel94_94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel95_95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel96_96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel97_97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel98_98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JLabel jLabel99_99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel15_15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel27_27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel28_28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel29_29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel30_30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel31_31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel32_32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel36_36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel37_37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel38_38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4_4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel lecturersChrt;
    private javax.swing.JButton lecturersStatisticData;
    private javax.swing.JScrollPane locDetailScrolPane;
    private javax.swing.JTable locDetails;
    private javax.swing.JPanel locationAdd_panel;
    private javax.swing.JPanel locationDet_panel;
    private javax.swing.JLabel locationDet_title;
    private javax.swing.JPanel locationDetails;
    private javax.swing.JPanel locationEdit_panel;
    private javax.swing.JTable locationInfo;
    private javax.swing.JButton locationMainBtn;
    private javax.swing.JPanel locationPanel;
    private javax.swing.JPanel location_details;
    private javax.swing.JPanel location_sessions;
    private javax.swing.JCheckBox monday;
    private javax.swing.JPanel notAvailableTimes;
    private javax.swing.JPanel notAvailable_lecturers;
    private javax.swing.JPanel notAvailable_session;
    private javax.swing.JPanel panelChart;
    private javax.swing.JPanel parent_wds;
    private javax.swing.JPanel programme;
    private javax.swing.JComboBox<String> rType;
    private javax.swing.JComboBox<String> rType1;
    private javax.swing.JButton reservationBtn;
    private javax.swing.JLabel reservationIcon;
    private javax.swing.JLabel reservationLabel;
    private javax.swing.JTextField room;
    private javax.swing.JTextField room1;
    private javax.swing.JLabel roomAndTagIcon;
    private javax.swing.JLabel roomAndTagLabel;
    private javax.swing.JLabel roomEditLabel;
    private javax.swing.JLabel roomLabel;
    private javax.swing.JLabel roomTypeEditLabel;
    private javax.swing.JLabel roomTypeLabel;
    private javax.swing.JPanel room_tagDets;
    private javax.swing.JPanel roomreservation;
    private javax.swing.JTextField sName;
    private javax.swing.JTextField sa;
    private javax.swing.JTextField sa1;
    private javax.swing.JComboBox<String> sa2;
    private javax.swing.JComboBox<String> sa3;
    private javax.swing.JComboBox<String> sa4;
    private javax.swing.JComboBox<String> sa5;
    private javax.swing.JComboBox<String> sa6;
    private javax.swing.JComboBox<String> sa7;
    private javax.swing.JCheckBox saturday;
    private javax.swing.JTextField sd;
    private javax.swing.JTextField sd1;
    private javax.swing.JComboBox<String> sd2;
    private javax.swing.JComboBox<String> sd3;
    private javax.swing.JComboBox<String> sd4;
    private javax.swing.JComboBox<String> sd5;
    private javax.swing.JComboBox<String> sd6;
    private javax.swing.JComboBox<String> sd7;
    private javax.swing.JTextField se;
    private javax.swing.JTextField se1;
    private javax.swing.JComboBox<String> se2;
    private javax.swing.JComboBox<String> se3;
    private javax.swing.JComboBox<String> se4;
    private javax.swing.JComboBox<String> se5;
    private javax.swing.JComboBox<String> se6;
    private javax.swing.JComboBox<String> se7;
    private javax.swing.JButton search;
    private javax.swing.JButton searchBuild;
    private javax.swing.JLabel searchBuildInEditLabel;
    private javax.swing.JPanel sessionsPanel;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JButton statisticBtn;
    private javax.swing.JLabel statisticImage;
    private javax.swing.JLabel statisticTitel;
    private javax.swing.JPanel statistical_panel;
    private javax.swing.JPanel statsticsPanel;
    private javax.swing.JPanel studentPanel;
    private javax.swing.JButton studentStatisticData;
    private javax.swing.JPanel subGroupNumbers;
    private javax.swing.JPanel subjectChart;
    private javax.swing.JTable subjectTable;
    private javax.swing.JButton subject_add;
    private javax.swing.JPanel subject_detail;
    private javax.swing.JPanel subject_detail1;
    private javax.swing.JButton subject_details;
    private javax.swing.JPanel subject_edit;
    private javax.swing.JPanel subjects;
    private javax.swing.JButton subjectsStatisticData;
    private javax.swing.JPanel subjects_add;
    private javax.swing.JCheckBox sunday;
    private javax.swing.JPanel tagsPanel;
    private javax.swing.JLabel test;
    private javax.swing.JCheckBox thursday;
    private javax.swing.JPanel timetablesPanel;
    private javax.swing.JCheckBox tuesday;
    private javax.swing.JCheckBox up_friday;
    private javax.swing.JCheckBox up_monday;
    private javax.swing.JCheckBox up_saturday;
    private javax.swing.JCheckBox up_sunday;
    private javax.swing.JCheckBox up_thursday;
    private javax.swing.JCheckBox up_tuesday;
    private javax.swing.JCheckBox up_wednesday;
    private javax.swing.JButton update_sub;
    private javax.swing.JButton view_sub;
    private javax.swing.JLabel visualizationTitle;
    private javax.swing.JLabel wds_f_add_img;
    private javax.swing.JPanel wds_f_add_pnl;
    private javax.swing.JLabel wds_f_view_img;
    private javax.swing.JPanel wds_f_view_pnl;
    private javax.swing.JPanel wds_first;
    private javax.swing.JButton wds_first_add;
    private javax.swing.JButton wds_first_view;
    private javax.swing.JButton wds_fourth_backbtn;
    private javax.swing.JLabel wds_fourth_days_lbl;
    private javax.swing.JTextField wds_fourth_hrs;
    private javax.swing.JLabel wds_fourth_hrs_lbl;
    private javax.swing.JTextField wds_fourth_mins;
    private javax.swing.JLabel wds_fourth_mins_lbl;
    private javax.swing.JComboBox<String> wds_fourth_ndays;
    private javax.swing.JLabel wds_fourth_no_lbl;
    private javax.swing.JPanel wds_fourth_pn;
    private javax.swing.JComboBox<String> wds_fourth_slot;
    private javax.swing.JLabel wds_fourth_slot_lbl;
    private javax.swing.JLabel wds_fourth_tid_lbl;
    private javax.swing.JLabel wds_fourth_time_lbl;
    private javax.swing.JLabel wds_fourth_title;
    private javax.swing.JComboBox<String> wds_fourth_type;
    private javax.swing.JLabel wds_fourth_type_lbl;
    private javax.swing.JPanel wds_fourth_update;
    private javax.swing.JButton wds_fourth_updatebtn;
    private javax.swing.JLabel wds_sec_days_lbl;
    private javax.swing.JTextField wds_sec_hrs;
    private javax.swing.JLabel wds_sec_hrs_lbl;
    private javax.swing.JTextField wds_sec_mins;
    private javax.swing.JLabel wds_sec_mins_lbl;
    private javax.swing.JComboBox<String> wds_sec_ndays;
    private javax.swing.JLabel wds_sec_no_lbl;
    private javax.swing.JPanel wds_sec_pn;
    private javax.swing.JComboBox<String> wds_sec_slot;
    private javax.swing.JLabel wds_sec_slot_lbl;
    private javax.swing.JLabel wds_sec_time_lbl;
    private javax.swing.JLabel wds_sec_title;
    private javax.swing.JComboBox<String> wds_sec_type;
    private javax.swing.JLabel wds_sec_type_lbl;
    private javax.swing.JPanel wds_second;
    private javax.swing.JButton wds_second_add_btn;
    private javax.swing.JButton wds_second_back_btn;
    private javax.swing.JButton wds_second_view_btn;
    private javax.swing.JButton wds_third_backbtn;
    private javax.swing.JButton wds_third_deletebtn;
    private javax.swing.JButton wds_third_editbtn;
    private javax.swing.JScrollPane wds_third_scroll;
    private javax.swing.JTable wds_third_table;
    private javax.swing.JLabel wds_third_title;
    private javax.swing.JPanel wds_third_viewdetails;
    private javax.swing.JCheckBox wednesday;
    private javax.swing.JPanel workingdaysPanel;
    // End of variables declaration//GEN-END:variables

    public void resetEmpData() {

        lecturer_add.la.setText("");
        lecturer_add.la1.setText("");
        lecturer_add.la2.setSelectedItem("Select Faculty");
        lecturer_add.la3.setSelectedItem("Select Department");
        lecturer_add.la4.setSelectedItem("Select Center");
        lecturer_add.la5.setSelectedItem("Select Building");
        lecturer_add.la6.setSelectedItem("Select Level");
        lecturer_add.la7.setText("");

    }

    public void resetSubData() {

        sa.setText("");
        sa1.setText("");
        sa2.setSelectedItem("Select Year");
        sa3.setSelectedItem("Select Semester");
        sa4.setSelectedItem("Select Lecture Hours");
        sa5.setSelectedItem("Select Tutorial Hours");
        sa6.setSelectedItem("Select Lab Hours");
        sa7.setSelectedItem("Select Evaluation Hours");

    }

    public void setemployeeTable() {

        try {

            int rows = 0;
            int rowIndex = 0;

            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from lec order by empID desc");

            if (rs.next()) {

                rs.last();
                rows = rs.getRow();
                rs.beforeFirst();
            }

            String[][] data = new String[rows][8];

            while (rs.next()) {

                data[rowIndex][0] = rs.getInt(1) + "";
                data[rowIndex][1] = rs.getString(2);
                data[rowIndex][2] = rs.getString(3);
                data[rowIndex][3] = rs.getString(4);
                data[rowIndex][4] = rs.getString(5);
                data[rowIndex][5] = rs.getString(6);
                data[rowIndex][6] = rs.getInt(7) + "";
                data[rowIndex][7] = rs.getString(8);

                rowIndex++;

            }

            String[] cols = {"EmpID", "Name", "Faculty", "Department", "Center", "Building", "Level", "Rank"};
            DefaultTableModel model = new DefaultTableModel(data, cols);
            view_lecturers.employeeTable.setModel(model);

            rs.close();
            s.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this, ex);

        }

    }

    public void setsubjectTable() {

        try {

            int rows = 0;
            int rowIndex = 0;

            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from subject order by code desc");

            if (rs.next()) {

                rs.last();
                rows = rs.getRow();
                rs.beforeFirst();
            }

            String[][] data = new String[rows][8];

            while (rs.next()) {

                data[rowIndex][0] = rs.getString(1);
                data[rowIndex][1] = rs.getString(2);
                data[rowIndex][2] = rs.getString(3);
                data[rowIndex][3] = rs.getString(4);
                data[rowIndex][4] = rs.getString(5);
                data[rowIndex][5] = rs.getString(6);
                data[rowIndex][6] = rs.getString(6);
                data[rowIndex][7] = rs.getString(8);

                rowIndex++;

            }

            String[] cols = {"Subject Code", "Name", "Year", "Sem", "Lec_hrs", "Tute_hrs", "Lab_hrs", "Eva_hrs"};
            DefaultTableModel model = new DefaultTableModel(data, cols);
            subjectTable.setModel(model);

            rs.close();
            s.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this, ex);

        }

    }

    public boolean validateInputAddAcademic() {
        return !(jTextField1.getText().isEmpty() || jTextArea1.getText().isEmpty());
    }

    public void loadDataAcademic() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            String qry = "SELECT * FROM academic";
            ResultSet rs = DBConnect.search(qry);
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("academic.id"));
                v.add(rs.getString("academic.year"));
                v.add(rs.getString("academic.description"));
                dtm.addRow(v);
            }
            for (int i = 0; i < jTable1.getColumnCount(); i++) {
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(jLabel1.CENTER);
                jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadId1() {
        try {
            String qry = "SELECT COUNT(academic.id) as count FROM academic";
            ResultSet rs = DBConnect.search(qry);
            rs.next();
            if (rs.getInt("count") == 0) {
                id1 = id1 + 1;
            } else {
                int i = rs.getInt("count");
                i++;
                id1 = id1 + i;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDetailsAcademic() {
        try {
            String qry = "SELECT * FROM academic WHERE id='" + anum + "'";
            ResultSet rs = DBConnect.search(qry);
            rs.first();
            jTextField2.setText(rs.getString("year"));
            jTextField4.setText(rs.getString("description"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadCombo() {
        try {
            String qry = "SELECT academic.year FROM academic";
            ResultSet rs = DBConnect.search(qry);
            jComboBox1.removeAllItems();
            jComboBox2.removeAllItems();
            jComboBox2.addItem("Select...");
            jComboBox1.addItem("Select...");
            while (rs.next()) {
                jComboBox1.addItem(rs.getString("year"));
                jComboBox2.addItem(rs.getString("year"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadId2() {
        try {
            String qry = "SELECT COUNT(programme.id) as count FROM programme";
            ResultSet rs = DBConnect.search(qry);
            rs.next();
            if (rs.getInt("count") == 0) {
                id2 = id2 + 1;
            } else {
                int i = rs.getInt("count");
                i++;
                id2 = id2 + i;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validateInputAddProgramme() {
        return !(jTextField3.getText().isEmpty());
    }

    public void loadDataProgramme() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            String qry = "SELECT * FROM programme";
            ResultSet rs = DBConnect.search(qry);
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("programme.id"));
                v.add(rs.getString("programme.programme"));
                v.add(rs.getString("programme.start_year"));
                v.add(rs.getString("programme.end_year"));
                dtm.addRow(v);
            }
            for (int i = 0; i < jTable2.getColumnCount(); i++) {
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(jLabel2.CENTER);
                jTable2.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDetailsProgramme() {
        try {
            String qry = "SELECT * FROM programme WHERE id='" + pnum + "'";
            ResultSet rs = DBConnect.search(qry);
            rs.first();
            loadCombo2(rs.getString("start_year"), rs.getString("end_year"));
            jTextField5.setText(rs.getString("programme"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadCombo2(String item1, String item2) {
        try {
            String qry = "SELECT academic.year FROM academic";
            ResultSet rs = DBConnect.search(qry);
            jComboBox4.removeAllItems();
            jComboBox5.removeAllItems();
            jComboBox4.addItem(item1);
            jComboBox5.addItem(item2);
            while (rs.next()) {
                jComboBox4.addItem(rs.getString("year"));
                jComboBox5.addItem(rs.getString("year"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadId3() {
        try {
            String qry = "SELECT COUNT(groups.id) as count FROM groups";
            ResultSet rs = DBConnect.search(qry);
            rs.next();
            if (rs.getInt("count") == 0) {
                id3 = id3 + 1;
            } else {
                int i = rs.getInt("count");
                i++;
                id3 = id3 + i;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadDataGroup() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
            String qry = "SELECT * FROM groups";
            ResultSet rs = DBConnect.search(qry);
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("groups.id"));
                v.add(rs.getString("groups.batch"));
                v.add(rs.getString("groups.students"));
                v.add(rs.getString("groups.groups"));
                dtm.addRow(v);
            }
            for (int i = 0; i < jTable3.getColumnCount(); i++) {
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(jLabel3.CENTER);
                jTable3.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadCombo1() {
        try {
            String qry = "SELECT * FROM programme";
            ResultSet rs = DBConnect.search(qry);
            jComboBox3.removeAllItems();
            jComboBox3.addItem("Select...");
            while (rs.next()) {
                String start = rs.getString("start_year");
                String end = rs.getString("end_year");

                int startYears = Character.getNumericValue(start.charAt(1));
                int startSem = Character.getNumericValue(start.charAt(4));

                int endYear = Character.getNumericValue(end.charAt(1));
                int endSem = Character.getNumericValue(end.charAt(4));

                for (int i = startYears; i <= endYear; i++) {
                    for (int j = startSem; j < 3; j++) {
                        jComboBox3.addItem("Y".concat(String.valueOf(i)).concat(".").concat("S").concat(String.valueOf(j)).concat(".").concat(rs.getString("programme")));
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadId4() {
        try {
            String qry = "SELECT COUNT(subgroup.id) as count FROM subgroup";
            ResultSet rs = DBConnect.search(qry);
            rs.next();
            if (rs.getInt("count") == 0) {
                id4 = id4 + 1;
            } else {
                int i = rs.getInt("count");
                i++;
                id4 = id4 + i;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadDataTag() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel();
            String qry = "SELECT * FROM tag";
            ResultSet rs = DBConnect.search(qry);
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("tag.id"));
                v.add(rs.getString("tag.tag"));
                dtm.addRow(v);
            }
            for (int i = 0; i < jTable4.getColumnCount(); i++) {
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(jLabel4.CENTER);
                jTable4.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean validateInputAddGroup() {
        return !(jTextField7.getText().isEmpty() || jTextField9.getText().isEmpty());
    }

    public void setDetailsGroup() {
        try {
            String qry = "SELECT * FROM groups WHERE id='" + dnum + "'";
            ResultSet rs = DBConnect.search(qry);
            rs.first();
            loadCombo3(rs.getString("batch"));
            jTextField10.setText(rs.getString("students"));
            jTextField11.setText(rs.getString("groups"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadCombo3(String item) {
        try {
            String qry = "SELECT groups.batch FROM groups";
            ResultSet rs = DBConnect.search(qry);
            jComboBox8.removeAllItems();
            jComboBox8.addItem(item);
            while (rs.next()) {
                jComboBox8.addItem(rs.getString("batch"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTableGroup() {

        try {
            DefaultTableModel dtm = (DefaultTableModel) jTable5.getModel();
            String qry = "SELECT * FROM groups";
            ResultSet rs = DBConnect.search(qry);
            dtm.setRowCount(0);
            int id = 0;
            while (rs.next()) {

                String batch = rs.getString("batch");
                String group = rs.getString("groups");

                int group_int = Integer.parseInt(group);

                for (int i = 1; i <= group_int; i++) {
                    id++;
                    Vector v = new Vector();
                    v.add(id);
                    v.add(batch.concat(".0").concat(String.valueOf(i)));
                    dtm.addRow(v);
                }

            }

            for (int i = 0; i < jTable5.getColumnCount(); i++) {
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(jLabel5.CENTER);
                jTable5.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadCombo2() {
        try {
            String qry = "SELECT * FROM groups";
            ResultSet rs = DBConnect.search(qry);
            jComboBox6.removeAllItems();
            jComboBox6.addItem("Select...");
            while (rs.next()) {
                String batch = rs.getString("batch");
                String group = rs.getString("groups");

                int group_int = Integer.parseInt(group);

                for (int i = 1; i <= group_int; i++) {
                    jComboBox6.addItem(batch.concat(".0").concat(String.valueOf(i)));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean validateInputAddSubGroup() {
        return !(jTextField12.getText().isEmpty());
    }

    public void loadDataSubGroup() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) jTable6.getModel();
            String qry = "SELECT * FROM subgroup";
            ResultSet rs = DBConnect.search(qry);
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("subgroup.id"));
                v.add(rs.getString("subgroup.group"));
                v.add(rs.getString("subgroup.sub_group"));
                dtm.addRow(v);
            }
            for (int i = 0; i < jTable6.getColumnCount(); i++) {
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(jLabel6.CENTER);
                jTable6.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTableSubGroup() {

        try {
            DefaultTableModel dtm = (DefaultTableModel) jTable7.getModel();
            String qry = "SELECT * FROM subgroup";
            ResultSet rs = DBConnect.search(qry);
            dtm.setRowCount(0);
            int id = 0;
            while (rs.next()) {

                String group = rs.getString("group");
                String subgroup = rs.getString("sub_group");

                int subgroup_int = Integer.parseInt(subgroup);

                for (int i = 1; i <= subgroup_int; i++) {
                    id++;
                    Vector v = new Vector();
                    v.add(id);
                    v.add(group.concat(".").concat(String.valueOf(i)));
                    dtm.addRow(v);
                }

            }

            for (int i = 0; i < jTable7.getColumnCount(); i++) {
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(jLabel7.CENTER);
                jTable7.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setDetailsSubGroup() {
        try {
            String qry = "SELECT * FROM subgroup WHERE id='" + snum + "'";
            ResultSet rs = DBConnect.search(qry);
            rs.first();
            loadCombo4(rs.getString("group"));
            jTextField13.setText(rs.getString("sub_group"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadCombo4(String item) {
        try {
            String qry = "SELECT subgroup.group FROM subgroup";
            ResultSet rs = DBConnect.search(qry);
            jComboBox7.removeAllItems();
            jComboBox7.addItem(item);
            while (rs.next()) {
                jComboBox7.addItem(rs.getString("group"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadId5() {
        try {
            String qry = "SELECT COUNT(tag.id) as count FROM tag";
            ResultSet rs = DBConnect.search(qry);
            rs.next();
            if (rs.getInt("count") == 0) {
                id5 = id5 + 1;
            } else {
                int i = rs.getInt("count");
                i++;
                id5 = id5 + i;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDetailsTag() {
        try {
            String qry = "SELECT * FROM tag WHERE id='" + tnum + "'";
            ResultSet rs = DBConnect.search(qry);
            rs.first();
            jTextField14.setText(rs.getString("tag"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

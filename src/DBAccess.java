/**
 * Created by Dasuni on 11/3/2014.
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBAccess {

        public Object javaObject=null;
        ArrayList<FootballClub> clubObjects =new ArrayList<FootballClub>();
        ArrayList<FootballPlayer> playerObjects =new ArrayList<FootballPlayer>();


        public Object getJavaObject() {
            return javaObject;
        }


        public void setJavaObject(Object javaObject) {
            this.javaObject = javaObject;
        }


        public  void saveFootballClub() throws Exception{
            try{
                Connection connec = DBConnect.getConnection();
                PreparedStatement ps = null;
                String sql = null;

                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bos);

                oos.writeObject(javaObject);
                oos.flush();
                oos.close();
                bos.close();

                byte[] data = bos.toByteArray();


                sql="INSERT INTO footballclub  VALUES(?)";
                ps = connec.prepareStatement(sql);
                ps.setObject(1, data);
                ps.executeUpdate();

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }


        public Object getFtClubObject() throws Exception{
            Object rmObj = null;
            Connection connec = DBConnect.getConnection();
            PreparedStatement ps = null;

            ResultSet rs=null;
            String sql=null;

            sql="SELECT * FROM footballclub";

            ps=connec.prepareStatement(sql);
            rs=ps.executeQuery();

            while (rs.next())
            {
                ByteArrayInputStream bais;
                ObjectInputStream ins;

                try {


                    bais = new ByteArrayInputStream(rs.getBytes("clubobj"));
                    ins = new ObjectInputStream(bais);

                    FootballClub mc =(FootballClub)ins.readObject();
                    clubObjects.add(mc);
                    System.out.println("Object in value :"+mc.getClubName());
                    ins.close();

                }
                catch (Exception e) {

                    e.printStackTrace();
                }

            }

            return rmObj;
        }






        public  void saveFootballPlayer() throws Exception{
            try{
                 Connection connec = DBConnect.getConnection();
                 PreparedStatement ps = null;
                 String sql = null;

                 ByteArrayOutputStream bos = new ByteArrayOutputStream();
                 ObjectOutputStream oos = new ObjectOutputStream(bos);

                    oos.writeObject(javaObject);
                    oos.flush();
                    oos.close();
                    bos.close();

            byte[] data = bos.toByteArray();


            sql="INSERT INTO footballplayer  VALUES(?)";
            ps = connec.prepareStatement(sql);
            ps.setObject(1, data);
            ps.executeUpdate();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }


    public Object getFtPlayerObject() throws Exception{
        Object rmObj = null;
        Connection connec = DBConnect.getConnection();
        PreparedStatement ps = null;

        ResultSet rs=null;
        String sql=null;

        sql="SELECT * FROM footballplayer";

        ps=connec.prepareStatement(sql);
        rs=ps.executeQuery();

        while (rs.next())
        {
            ByteArrayInputStream bais;
            ObjectInputStream ins;

            try {


                bais = new ByteArrayInputStream(rs.getBytes("playerobj"));
                ins = new ObjectInputStream(bais);

                FootballPlayer player =(FootballPlayer)ins.readObject();
                playerObjects.add(player);
                System.out.println("Object in value :"+player.getfName());
                ins.close();

            }
            catch (Exception e) {

                e.printStackTrace();
            }

        }

        return rmObj;
    }









    }








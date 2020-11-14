package pokemon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** テーブルt2に対するDAO **/
public class T2DAO {

	/** クラスの初期化時に一度だけ実行される **/
	static {
		try {
			Class.forName("org.h2.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** テーブルt2もすべてのデータを返す */
	public List<Pokemon>findAll(){
		List<Pokemon>pokemonList = new ArrayList<Pokemon>();
		String url = "jdbc:h2:tcp://localhost/D:/pleiades/h2/s1832074";
		try(Connection conn = DriverManager.getConnection(url,"user","pass");){
			String sql = "SELECT 番号,名前,攻撃力,防御力 ,体力 FROM t2";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			int rows = 0;
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				rows++;
				int number = rs.getInt("番号");
				String name= rs.getString("名前");
				int attack = rs.getInt("攻撃力");
				int defence = rs.getInt("防御力");
				int physical = rs.getInt("体力");
				Pokemon pokemon = new Pokemon();
				pokemon.setNumber(number);
				pokemon.setName(name);
				pokemon.setAttack(attack);
				pokemon.setDefence(defence);
				pokemon.setPhysical(physical);

				pokemonList.add(pokemon);
			}
			System.out.println(rows+"件");
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return pokemonList;
	}

	/** テーブルt2にデータを追加する。成功したらtrueを返す */
	public boolean create(int number, String name, int attack, int defence ,int physical) {
		String url = "jdbc:h2:tcp://localhost/D:/pleiades/h2/s1832074";
		try(Connection conn = DriverManager.getConnection(url,"user","pass");){
			String sql = "INSERT INTO T2(番号,名前,攻撃力,防御力,体力) VALUES(?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			 pStmt.setInt(1, number);
			 pStmt.setString(2, name);
			 pStmt.setInt(3, attack);
			 pStmt.setInt(4, defence);
			 pStmt.setInt(5, physical);
			 int result = pStmt.executeUpdate();
			 if (result != 1) return false;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean delete(int number) {
		String url = "jdbc:h2:tcp://localhost/D:/pleiades/h2/s1832074";
		try(Connection conn = DriverManager.getConnection(url,"user","pass");){
			String sql = "DELETE FROM T2 WHERE 番号 = VALUES(?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, number);
			int result = pStmt.executeUpdate();
			if (result != 1) return false;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean update(int number, String name, String attack, String defence, String physical) {
		String url = "jdbc:h2:tcp://localhost/D:/pleiades/h2/s1832074";
		try(Connection conn = DriverManager.getConnection(url,"user","pass");){
			//1つでも空欄があれば
			if(name=="null"||attack=="null" || defence=="null"||physical=="null"){

				//空欄が3つある場合の処理
				//体力変更
				if(name=="null"&& attack=="null" && defence=="null") {
					String sql = "UPDATE T2 SET 体力 = ? WHERE 番号 = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					int upphysical = Integer.parseInt(physical);
					System.out.printf("%s %s \n", number,physical);
					pStmt.setInt(1, upphysical);
					pStmt.setInt(2, number);
					int result = pStmt.executeUpdate();
					if (result != 1) return false;
				}
				//防御力変更
				else if(name=="null"&& attack=="null" && physical=="null") {
					String sql = "UPDATE T2 SET 防御力 = ? WHERE 番号 = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					int updefence = Integer.parseInt(defence);
					System.out.printf("%s %s \n", number,defence);
					pStmt.setInt(1, updefence);
					pStmt.setInt(2, number);
					int result = pStmt.executeUpdate();
					if (result != 1) return false;
				}
				//攻撃力変更
				else if(name=="null"&& defence=="null" && physical=="null") {
					String sql = "UPDATE T2 SET 攻撃力 = ? WHERE 番号 = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					int upattack = Integer.parseInt(attack);
					System.out.printf("%s %s \n", number,attack);
					pStmt.setInt(1, upattack);
					pStmt.setInt(2, number);
					int result = pStmt.executeUpdate();
					if (result != 1) return false;
				}
				//名前変更
				else if(attack=="null"&&defence=="null" && physical=="null") {
					String sql = "UPDATE T2 SET 名前 = ? WHERE 番号 = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					System.out.printf("%s %s \n", number,name);
					pStmt.setString(1, name);
					pStmt.setInt(2, number);
					int result = pStmt.executeUpdate();
					if (result != 1) return false;
				}

				//空欄が2つある場合の処理
				//防御力と体力の変更
				else if(name=="null"&& attack=="null") {
					String sql = "UPDATE T2 SET 防御力 = ?,体力 = ? WHERE 番号 = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					int updefence = Integer.parseInt(defence);
					int upphysical = Integer.parseInt(physical);
					System.out.printf("%s %s %s \n", number,defence,physical);
					pStmt.setInt(1, updefence);
					pStmt.setInt(2, upphysical);
					pStmt.setInt(3, number);
					int result = pStmt.executeUpdate();
					if (result != 1) return false;
				}
				//攻撃力と体力の変更
				else if(name=="null"&& defence=="null") {
					String sql = "UPDATE T2 SET 攻撃力 = ?,体力 = ? WHERE 番号 = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					int upattack = Integer.parseInt(attack);
					int upphysical = Integer.parseInt(physical);
					System.out.printf("%s %s %s\n", number,attack,physical);
					pStmt.setInt(1, upattack);
					pStmt.setInt(2, upphysical);
					pStmt.setInt(3, number);
					int result = pStmt.executeUpdate();
					if (result != 1) return false;
				}
				//攻撃力と防御力の変更
				else if(name=="null"&& physical=="null") {
					String sql = "UPDATE T2 SET 攻撃力 = ?,防御力 = ? WHERE 番号 = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					int upattack = Integer.parseInt(attack);
					int updefence = Integer.parseInt(defence);
					System.out.printf("%s %s %s\n", number,attack,defence);
					pStmt.setInt(1, upattack);
					pStmt.setInt(2, updefence);
					pStmt.setInt(3, number);
					int result = pStmt.executeUpdate();
					if (result != 1) return false;
				}
				//名前と体力の変更
				else if(defence=="null"&& attack=="null") {
					String sql = "UPDATE T2 SET 名前 = ?,体力 = ? WHERE 番号 = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					int upphysical = Integer.parseInt(physical);
					System.out.printf("%s %s %s\n", number,name,physical);
					pStmt.setString(1, name);
					pStmt.setInt(2, upphysical);
					pStmt.setInt(3, number);
					int result = pStmt.executeUpdate();
					if (result != 1) return false;
				}
				//名前と防御力の変更
				else if(attack=="null"&& physical=="null") {
					String sql = "UPDATE T2 SET 名前= ?,防御力 = ? WHERE 番号 = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					int updefence = Integer.parseInt(defence);
					System.out.printf("%s %s %s\n", number,name,defence);
					pStmt.setString(1, name);
					pStmt.setInt(2, updefence);
					pStmt.setInt(3, number);
					int result = pStmt.executeUpdate();
					if (result != 1) return false;
				}
				//名前と攻撃力の変更
				else if(physical=="null"&& defence=="null") {
					String sql = "UPDATE T2 SET 名前= ?,攻撃力 = ? WHERE 番号 = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					int upattack = Integer.parseInt(attack);
					System.out.printf("%s %s %s\n", number,name,attack);
					pStmt.setString(1, name);
					pStmt.setInt(2, upattack);
					pStmt.setInt(3, number);
					int result = pStmt.executeUpdate();
					if (result != 1) return false;
				}

				//空欄が1つだけの処理
				//名前が入力無し
				else if(name=="null"){
					String sql = "UPDATE T2 SET 攻撃力 =? ,防御力=?,体力=? WHERE 番号 = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					int upattack = Integer.parseInt(attack);
					int updefence = Integer.parseInt(defence);
					int upphysical = Integer.parseInt(physical);
					System.out.printf("%s %s %s %s \n", number, attack,defence,physical);
					pStmt.setInt(1, upattack);
					pStmt.setInt(2, updefence);
					pStmt.setInt(3, upphysical);
					pStmt.setInt(4, number);
					int result = pStmt.executeUpdate();
					if (result != 1) return false;
				}
				//攻撃力が入力無し
				else if(attack=="null") {
					String sql = "UPDATE T2 SET 名前 = ?,防御力=?,体力=? WHERE 番号 = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					int updefence = Integer.parseInt(defence);
					int upphysical = Integer.parseInt(physical);
					System.out.printf("%s %s %s %s \n", number, name,defence,physical);
					pStmt.setString(1, name);
					pStmt.setInt(2, updefence);
					pStmt.setInt(3, upphysical);
					pStmt.setInt(4, number);
					int result = pStmt.executeUpdate();
					if (result != 1) return false;
				}
				//防御力が入力無し
				else if(defence=="null"){
					String sql = "UPDATE T2 SET 名前 = ?,攻撃力 =? ,体力=? WHERE 番号 = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					int upattack = Integer.parseInt(attack);
					int upphysical = Integer.parseInt(physical);
					System.out.printf("%s %s %s %s \n", number, name, attack,physical);
					pStmt.setString(1, name);
					pStmt.setInt(2, upattack);
					pStmt.setInt(3, upphysical);
					pStmt.setInt(4, number);
					int result = pStmt.executeUpdate();
					if (result != 1) return false;
				}
				//体力が入力無し
				else if(physical=="null"){
					String sql = "UPDATE T2 SET 名前 = ?,攻撃力 =? ,防御力=? WHERE 番号 = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					int upattack = Integer.parseInt(attack);
					int updefence = Integer.parseInt(defence);
					System.out.printf("%s %s %s %s \n", number, name, attack,defence);
					pStmt.setString(1, name);
					pStmt.setInt(2, upattack);
					pStmt.setInt(3, updefence);
					pStmt.setInt(4, number);
					int result = pStmt.executeUpdate();
					if (result != 1) return false;
				}

			}
			//空欄無し
			else {
				String sql = "UPDATE T2 SET 名前 = ?,攻撃力 =? ,防御力=?,体力=? WHERE 番号 = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				int upattack = Integer.parseInt(attack);
				int updefence = Integer.parseInt(defence);
				int upphysical = Integer.parseInt(physical);
				System.out.printf("%s %s %s %s %s \n", number, name, attack,defence,physical);
				pStmt.setString(1, name);
				pStmt.setInt(2, upattack);
				pStmt.setInt(3, updefence);
				pStmt.setInt(4, upphysical);
				pStmt.setInt(5, number);
				int result = pStmt.executeUpdate();
				if (result != 1) return false;
			}

		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
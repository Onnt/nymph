package cn.virde.nymph.db.mysql;

import cn.virde.nymph.db.ConnInfo;
import cn.virde.nymph.enums.common.DBStyle;

public class SqlServer<T> extends MySql<T>{

	public SqlServer(String ip, String dbName, String user, String pass) {
		super(ip, dbName, user, pass);
		info.setStyle(DBStyle.SQLSERVER);
	}
	public SqlServer(ConnInfo connInfo) {
		super(connInfo);
		connInfo.setStyle(DBStyle.SQLSERVER);
		info = connInfo;
	}
}

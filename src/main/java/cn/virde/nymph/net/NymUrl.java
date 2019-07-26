package cn.virde.nymph.net;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class NymUrl{

    private URL url ;

    public NymUrl(String spec) throws MalformedURLException {
        this.url = new URL(spec);
    }

    public String getProtocol() {
        return url.getProtocol();
    }
    public String getHost() {
        return url.getHost();
    }
    public int getPort() {
        return url.getPort();
    }
    public String getQuery() {
        return url.getQuery();
    }
    public String getPath() {
        return url.getPath();
    }
    /**
     * 返回内容相当于 getPath()+getQuery()
     * @return
     */
    public String getFile() {
        return url.getFile();
    }
    public String getRef() {
        return url.getRef();
    }

    public Map<String,String> getQueryMap(){
        String query = getQuery();
        if(StringUtils.isEmpty(query)) return null;

        Map<String,String> respMap = new HashMap<>();
        String[] kvs = query.split("&");
        for(String kv : kvs) {
            if(kv.contains("=")) {
                String[] param = kv.split("=");
                respMap.put(param[0], param[1]);
            }else {
                respMap.put(kv, "");
            }
        }
        return respMap ;
    }
    public boolean removeQueryByName(String name) throws MalformedURLException {
        Map<String,String> queryMap = getQueryMap();
        if(queryMap==null) return false;
        if(queryMap.containsKey(name)) {
            queryMap.remove(name);
            setQuery(queryMap);
            return true;
        }else {
            return false;
        }
    }
    public void addQuery(String key,String value) throws MalformedURLException {
        Map<String,String> queryMap = getQueryMap();
        queryMap.put(key,value);
        setQuery(queryMap);
    }
    public void setQuery(Map<String,String> queryMap) throws MalformedURLException {
        String queryString = toQueryString(queryMap);
        String file = url.getPath();
        if(queryString!=null) {
            file = url.getPath()+"?"+queryString;
        }
        this.url = new URL(url.getProtocol(),url.getHost(),url.getPort(),file);
    }

    public void removeRef() throws MalformedURLException {
        this.url = new URL(url.getProtocol(),url.getHost(),url.getPort(),url.getFile());
    }

    /**
     *  获取连接深度，比如：
     *  http://virde.cn 深度=0
     *  http://virde.cn/deep/test 深度=2
     *  http://virde.cn/deep/test/haha 深度=3
     * @return 获取连接深度
     */
    public int getDeep(){
        int deep = 0 ;
        if(StringUtils.isBlank(getPath())){
            return deep;
        }
        for(String sub : getPath().split("/")){
            if(!StringUtils.isBlank(sub)){
                deep++;
            }
        }
        return deep;
    }

    @Override
    public String toString() {
        return url.toString();
    }

    private String toQueryString(Map<String,String> queryMap) {
        if(queryMap==null||queryMap.size()==0) return null;
        StringBuffer sb = new StringBuffer();
        for(Map.Entry<String, String> m : queryMap.entrySet()) {
            sb.append(m.getKey()+"="+m.getValue()+"&");
        }
        return sb.toString().substring(0, sb.length()-1);
    }

    public static void main(String[] args) throws MalformedURLException {
        NymUrl url = new NymUrl("http://virde.cn/?sadf=sadfasdf&asdfasd=Dsd#sdfsd");
        System.out.println(url.getPath());
        System.out.println(url.getFile());
        System.out.println(url.getDeep());
    }
}

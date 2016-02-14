package admin;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

import dao.PageViewersDAO;

/**
 * Classe de representacao dos dados para geracao de relatorios
 * @author IgorBastos
 *
 */

@Entity
@Table(name = "pageViewers")
public class PageViewers {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;

	@Column(name = "url", length = 200, unique = false, nullable = false)
	private String url;

	@Column(name = "ip", length = 20, nullable = false)
	private String ip;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateTime", nullable = true)
	private Date dateTime;

	//Construtores
	public PageViewers(){}
	
	public PageViewers(String url, String ip, Date dateTime){
		this.setUrl(url);
		this.setIp(ip);
		this.setDateTime(dateTime);
	}

	//Getters & Setters
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	//Outros Metodos
	/**
	 * Busca no banco de dados as dez ultimas paginas acessadas
	 * 
	 * @param req
	 */
	public static List listarRelatorioAcessoReal() {
		List<PageViewers> relatorioAcessoReal = PageViewersDAO.getInstance().dezUltimasPagAcessadas();
		return relatorioAcessoReal;
	}
}

package br.com.uol.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.uol.dao.AvengersDAO;
import br.com.uol.dao.JusticeLeagueDAO;
import br.com.uol.dao.PlayerDAO;
import br.com.uol.idao.IAvengersDAO;
import br.com.uol.idao.IJusticeLeagueDAO;
import br.com.uol.idao.IPlayerDAO;
import br.com.uol.model.Group;
import br.com.uol.model.Heroe;
import br.com.uol.model.HeroeXML;
import br.com.uol.model.Player;
import br.com.uol.to.PlayerTO;
import br.com.uol.util.UtilFormat;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PlayerController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);
	private static final String URL_LIGA_JUSTICA = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml";
	private static final String URL_VINGADORES = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json";
	private static Boolean ENABLE_REQUEST = true;

	private IPlayerDAO playerDAO = new PlayerDAO();
	private IJusticeLeagueDAO justiceLeagueDAO = new JusticeLeagueDAO();
	private IAvengersDAO avengersDAO = new AvengersDAO();

	List<Player> listPlayer = new ArrayList<Player>(0);

	@RequestMapping("/")
	public ModelAndView execute(Locale locale, Model model) {
		logger.info("execute...");

		if (ENABLE_REQUEST) {
			this.getLigaDaJustica();
			this.getVingadores();
			ENABLE_REQUEST = false;
		}

		this.listPlayer = this.playerDAO.getAllPlayer();
		model.addAttribute("listPlayer", listPlayer);
		model.addAttribute("url", "./register");

		return this.redirecti("/player/consult");
	}

	@RequestMapping("/register")
	public ModelAndView initRegister(Locale locale, Model model) {
		logger.info("init register...");

		PlayerTO playerTO = new PlayerTO();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("playerForm", playerTO);
		model.addAttribute("url", "./");

		return this.redirecti("/player/register", params);
	}

	@RequestMapping(value = "/register/player", method = RequestMethod.POST)
	public ModelAndView addPlayer(@Valid @ModelAttribute("playerForm") PlayerTO p, BindingResult result) {
		String codeName = null;
		if (!result.hasErrors()) {
			try {
				Player player = new Player();
				player.setName(p.getName());
				player.setEmail(p.getEmail());
				player.setPhone(p.getPhone());
				player.setGroup(Group.fromValue(p.getGroup()));

				if (player.getGroup().equals(Group.LigaDaJustica)) {
					codeName = this.justiceLeagueDAO.getCodename();
				} else {
					codeName = this.avengersDAO.getCodename();
				}
				if (codeName != null) {
					player.setCodeName(codeName);
					this.playerDAO.AddPlayer(player);
					return this.handleAllSuccess("Cadastro efetuado!", "../");
				} else {
					return this.handleAllWarn("Não há codenomes disponiveis nessa lista!", "../");
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
				return this.handleAllException(e, "../");
			}
		} else {
			return this.redirecti("/player/register");
		}
	}

	private void getLigaDaJustica() {
		logger.info("getLigaDaJustica...");
		try {
			String xmlRet = this.sendGet(URL_LIGA_JUSTICA);
			HeroeXML heroesXML = (HeroeXML) UtilFormat.getObjectXML(xmlRet, HeroeXML.class).get(0);
			List<String> tempList = heroesXML.getCodeNames();
			this.justiceLeagueDAO.addListHeroes(tempList);

			logger.info("Justice League size => " + tempList.size());
		} catch (Exception e) {
			System.out.println("error get justice league!! \n" + e.getMessage());
		}
	}

	private void getVingadores() {
		logger.info("getVingadores...");
		try {
			String jsonRet = this.sendGet(URL_VINGADORES);
			jsonRet = jsonRet.substring(jsonRet.indexOf("["), jsonRet.lastIndexOf("}"));
			List<Heroe> tempList = (List<Heroe>) UtilFormat.getListJSON(jsonRet, Heroe.class);
			this.avengersDAO.addListHeroes(tempList);

			logger.info("Avengers => " + tempList.size());
		} catch (Exception e) {
			System.out.println("error get avengers!! \n" + e.getMessage());
		}
	}

}

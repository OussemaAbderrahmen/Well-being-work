package tn.esprit.spring.wecare.services;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.wecare.entities.Cagnotte;
import tn.esprit.spring.wecare.entities.WithDrawal;
import tn.esprit.spring.wecare.iservices.IWithDrawal;
import tn.esprit.spring.wecare.repositories.CagnotteRepository;
import tn.esprit.spring.wecare.repositories.DrawalRepository;

@Service
public class DrawalServiceImpl implements IWithDrawal {

	@Autowired
	DrawalRepository Drepo;
	@Autowired
	CagnotteRepository carepo;
	@Override
	public String addDrawal(WithDrawal d, Long idCagnotte) {
		String msg ="";
		double x = 0;
		Cagnotte c = carepo.getById(idCagnotte);
		double mc = c.getMoneyCollected();
		msg+="MoneyCollected before addWithDrawal : "+mc;
		double a = d.getAmmount();	
		x=mc-a;
		c.setMoneyCollected(x);
		msg+="\nMoneyCollected after addWithDrawal : "+x;
		c.getDrawals().add(d);
		d.setCagnotte(c);
		d.setDatewithdrawal(new Date());
		carepo.save(c);
		Drepo.save(d);
				return msg+="\nWith Drawal added successfuly " ;
	}

	@Override
	public WithDrawal UpdateDrawal(WithDrawal d) {	
		return this.Drepo.save(d);
	}

	@Override
	public List<WithDrawal> ListDrawal() {
		return Drepo.findAll();
	}

	@Override
	public void deleteDrawal(Long id) {
		Drepo.deleteById(id);
	}

}

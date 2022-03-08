package tn.esprit.spring.wecare.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WithDrawal {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idWithdrawal;
	private double Ammount;
	private Date datewithdrawal;

	@ManyToOne
	Cagnotte cagnotte;
}

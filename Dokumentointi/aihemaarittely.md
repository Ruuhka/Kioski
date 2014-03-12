#Aihemäärittely

**Aihe:** Kioski-ohjelma

Tarkoituksena on toteuttaa ohjelma oppilaskunnan kioskin varaston ja kassatoiminnan hallinnointiin, tavoitteena helpottaa oppilaskunnan kioskin toimintaa korvaamalla perinteinen kynä & tuotelista -järjestelmä. 

Ohjelma ylläpitää tietoja kioskin eri tuoteryhmistä ja niihin kuuluvista tuotteista, mukaan lukien tuotteiden hinnoittelu ja varastosaldot. Keskeisenä toiminnallisuutena on siis näiden tietojen tallennus, muokkaus, poisto ja haku.

Toisena keskeisenä toiminnallisuutena mukana on nettikaupoista tuttu ostoskoritoiminnallisuus, joka auttaa myyjän kassatoimintaa näyttämällä ostettavien tuotteiden määrät, hinnat ja yhteishinnan.

**Käyttäjät:** Kioskin myyjä

**Toiminnot:**

- Tuoteryhmien hallinta
	- lisäys
	- poisto
	- muokkaus
- Tuotteiden hallinta
	- lisäys
	- poisto
	- muokkaus
	- erityisesti hinnoittelu ja varastosaldot, kuuluminen tuoteryhmiin
- Tuotehaku
	- manuaalisesti tuoteryhmien kautta
	- nimen perusteella
	- tuotetunnuksen perusteella
	- suosituimmat tuotteet -pikahaku
- Ostoskori
	- haetun tuotteen lisääminen ostoskoriin (määrä valittavissa)
	- näyttää myytävien tuotteiden hinnat
	- laskee ja näyttää ostoskorin sisältämien tuotteiden kokonaishinnan
	- ostoskorin sisältämien tuotteiden myynti nappia painamalla
		- ostoskoriin ei voi lisätä enempää tuotteita kuin mitä varastossa on
		- myyntitapahtuman vahvistus
		- kun ostostapahtuma viedään loppuun, myytyjen tuotteiden varastosaldot päivittyvät automaattisesti
		- ohjelma voi ilmoittaa, kun myydyn tuotteen varastosaldo laskee tietyn (mahdollisesti tuotekohtaisen) rajan alle
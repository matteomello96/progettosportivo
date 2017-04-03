-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: centropolisportivo
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `calendario`
--

DROP TABLE IF EXISTS `calendario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calendario` (
  `NomeCalendario` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `AnnoValidita` year(4) NOT NULL,
  PRIMARY KEY (`NomeCalendario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendario`
--

LOCK TABLES `calendario` WRITE;
/*!40000 ALTER TABLE `calendario` DISABLE KEYS */;
INSERT INTO `calendario` VALUES ('Calendario del Centro Polisportivo',2017);
/*!40000 ALTER TABLE `calendario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disciplina` (
  `NomeDisciplina` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Descrizione` mediumtext CHARACTER SET utf8 NOT NULL,
  `Immagine` blob NOT NULL,
  `Calendario` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`NomeDisciplina`,`Calendario`),
  KEY `raccoglie(2)` (`Calendario`),
  CONSTRAINT `raccoglie(2)` FOREIGN KEY (`Calendario`) REFERENCES `calendario` (`NomeCalendario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` VALUES ('atletica','l \'atletica leggera è un insieme di discipline che possono essere sommariamente suddivise in :corse su pista,concorsi,prove multiple,corsa campestre. Può essere praticata dai 12 anni in su','PROGETTOimmagini progettoatletica.jpg','Calendario del Centro Polisportivo'),('calcio','Il calcio è uno sport di squadra,praticato da squadre composte da 11 giocatori.L\'obiettivo del gioco è quello di segnare più gol nella squadra avversaria. Le partite si disputano nella zona antistante l\'edificio. Possono giocare coloro che hanno dai 5 ai 20 anni','PROGETTOimmagini progettocalcio.jpg','Calendario del Centro Polisportivo'),('pallavolo','La pallavolo,o detta anche volley,è uno sport che si svolge tra due squadre di 6 giocatori ciascuna.Lo scopo della disciplina è realizzare punti facendo cadere la palla nel campo avversario.Ogni squadra può essere composta da 13 giocatori,ma solo in 6 entrano in campo.Il gioco in questione è adatto a coloro che hanno un\'età maggiore di 6 anni','PROGETTOimmagini progettopallavolo.jpg','Calendario del Centro Polisportivo'),('pesistica','La pesistica è una disciplina atletica nella quale gli atleti tentano di sollevare pesi montati su un bilanciere d\'acciaio.Le gare di pesistica sono diffuse sin dai tempi antichi. La disciplina è  adatta a coloro che hanno età maggiore di 15 anni','PROGETTOimmagini progettopesi.jpg','Calendario del Centro Polisportivo');
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplinedisponibili`
--

DROP TABLE IF EXISTS `disciplinedisponibili`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disciplinedisponibili` (
  `Combinazionelivdis` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Livello` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Disciplina` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `MaxIscrittiTurno` int(5) NOT NULL,
  `CostoMensile` int(5) NOT NULL,
  PRIMARY KEY (`Combinazionelivdis`,`Livello`,`Disciplina`),
  KEY `ddsssssaa_idx` (`Livello`),
  KEY `llkklkkokoko_idx` (`Disciplina`),
  KEY `ffvdfdfdf` (`Disciplina`,`Livello`),
  CONSTRAINT `ddsssssaa` FOREIGN KEY (`Livello`) REFERENCES `livello` (`NomeLivello`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `llkklkkokoko` FOREIGN KEY (`Disciplina`) REFERENCES `disciplina` (`NomeDisciplina`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplinedisponibili`
--

LOCK TABLES `disciplinedisponibili` WRITE;
/*!40000 ALTER TABLE `disciplinedisponibili` DISABLE KEYS */;
INSERT INTO `disciplinedisponibili` VALUES (1,'principiante','calcio',8,50),(2,'principiante','pallavolo',12,60),(3,'principiante','atletica',4,50),(4,'intermedio','pesistica',6,45),(5,'intermedio','calcio',7,55),(6,'intermedio','pallavolo',12,65),(7,'intermedio','atletica',4,55),(8,'avanzato','pesistica',5,50),(9,'avanzato','calcio',4,60),(10,'avanzato','pallavolo',12,70),(11,'avanzato','atletica',3,60),(12,'esperto','pesistica',4,55),(13,'esperto','calcio',5,65),(14,'esperto','pallavolo',12,75),(15,'esperto','atletica',3,65);
/*!40000 ALTER TABLE `disciplinedisponibili` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elencoutenti`
--

DROP TABLE IF EXISTS `elencoutenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elencoutenti` (
  `idutente` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `cognome` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `codicefiscale` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `via` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `numerocivico` tinyint(4) NOT NULL,
  `citta` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `telefono` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `mail` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `attivita` tinyint(1) NOT NULL,
  `connessione` tinyint(1) NOT NULL,
  `tipoutente` enum('T','I','R') COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idutente`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `password_UNIQUE` (`password`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elencoutenti`
--

LOCK TABLES `elencoutenti` WRITE;
/*!40000 ALTER TABLE `elencoutenti` DISABLE KEYS */;
INSERT INTO `elencoutenti` VALUES (1,'Marco','Rossi','RSSMRI94C20HT93K','Via Imperatore Adriano ',9,'Lecce','marcorossi94','aaaaa5','3886395842','mrossi@gmail.com',1,0,'T'),(2,'Maria','Toffa','TFFMRI79A41A866F','Via Dante Alighieri ',15,'Cavallino','mariatoffa79','aaaaa6','3687458951','titti79@yahoo.it',1,0,'T'),(3,'Luca','Marino','MRNLCU89B21E506F','Viale Europa ',98,'Lecce','marinoluca89','aaaaa7','3409874514','luke87@yahoo.it',1,0,'T'),(4,'Lucrezia','Conti','CNTLCR98T68E874J','Via Spagna ',18,'Merine','contilucrezia98','aaaaa8','3451478495','lucreziabella98@yahoo.it',1,0,'T'),(5,'Lorenzo','Cantini','CNTLRZ90T18D897L','Viale Lo Re ',108,'Lecce','istlorenzocantini90','bbbbbb8','3897484751','latinlover90@libero.it',1,0,'I'),(6,'Martino','Pollino','PLLMRT69T18H795O','Viale della Repubblica ',10,'Castri di Lecce','istrmartinopollino69','bbbbbb9','3278495780','pollinom69@libero.it',1,0,'I'),(7,'Laura','Romei','RMILRA85B60H793L','Via Dante Alighieri',96,'Lecce','istlauraromei85','oooopplllp9','3897548751','giulietta34@libero.it',1,0,'I'),(15,'Marco','Stella','STLMRC79C18D874K','Viale delle rose ',101,'Lequile','respmarcostella79','cccccc9','3325484751','stellinomark@gmail.com',1,0,'R');
/*!40000 ALTER TABLE `elencoutenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gara`
--

DROP TABLE IF EXISTS `gara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gara` (
  `CodiceGara` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NomeEvento` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `DataEvento` date NOT NULL,
  `Descrizione` mediumtext COLLATE utf8_unicode_ci NOT NULL,
  `InfoPagamento` enum('Gratuito','A pagamento') COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Gratuito',
  `CostoEvento` float NOT NULL,
  `Istruttoredisp` int(10) unsigned NOT NULL,
  PRIMARY KEY (`CodiceGara`,`Istruttoredisp`),
  UNIQUE KEY `uniquee` (`NomeEvento`,`DataEvento`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gara`
--

LOCK TABLES `gara` WRITE;
/*!40000 ALTER TABLE `gara` DISABLE KEYS */;
INSERT INTO `gara` VALUES (5,'gara di pesistica','2017-05-04','la seguente gara è per un livello intermedio','A pagamento',35,8),(6,'gara di calcio','2017-05-04','la seguente gara è per un livello intermedio','A pagamento',50,13);
/*!40000 ALTER TABLE `gara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gestioneturno`
--

DROP TABLE IF EXISTS `gestioneturno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gestioneturno` (
  `Codiceturno` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fasciaoraria` enum('08:30-09:30','09:30-10:30','10:30-11:30','11:30-12:30','12:30-13:30','15:30-16:30','16:30-17:30','17:30-18:30','18:30','19:30','19:30-20:30','20:30-21:30') CHARACTER SET utf8 NOT NULL,
  `Giornosettimana` enum('lunedi','martedi','mercoledi','giovedi','venerdi','sabato') CHARACTER SET utf8 NOT NULL,
  `Combinazionelivdis` int(10) unsigned NOT NULL,
  `Spazio` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`Codiceturno`,`Combinazionelivdis`,`Spazio`),
  UNIQUE KEY `koookkokk` (`fasciaoraria`,`Spazio`,`Giornosettimana`),
  KEY `XSAS_idx` (`Combinazionelivdis`),
  KEY `sssdds_idx` (`Spazio`),
  CONSTRAINT `XSAS` FOREIGN KEY (`Combinazionelivdis`) REFERENCES `disciplinedisponibili` (`Combinazionelivdis`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sssdds` FOREIGN KEY (`Spazio`) REFERENCES `spazio` (`NomeSpazio`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestioneturno`
--

LOCK TABLES `gestioneturno` WRITE;
/*!40000 ALTER TABLE `gestioneturno` DISABLE KEYS */;
INSERT INTO `gestioneturno` VALUES (1,'08:30-09:30','lunedi',1,'sala cardio'),(7,'08:30-09:30','martedi',1,'sala cardio'),(5,'08:30-09:30','mercoledi',1,'sala cardio'),(6,'10:30-11:30','lunedi',5,'sala fitness'),(2,'15:30-16:30','lunedi',1,'sala cardio'),(8,'15:30-16:30','martedi',1,'sala cardio');
/*!40000 ALTER TABLE `gestioneturno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iscrizionedisciplina`
--

DROP TABLE IF EXISTS `iscrizionedisciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iscrizionedisciplina` (
  `codiceiscrizionedisciplina` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dataazione` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tesserato` int(10) unsigned NOT NULL,
  `modalitapagamento` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `combinazionelivdis` int(10) unsigned NOT NULL,
  PRIMARY KEY (`codiceiscrizionedisciplina`,`tesserato`,`modalitapagamento`,`combinazionelivdis`),
  UNIQUE KEY `uniquede` (`tesserato`,`combinazionelivdis`),
  KEY `ttttttttttt_fk_idx` (`tesserato`),
  KEY `mmmmmmmmm_fk_idx` (`modalitapagamento`),
  KEY `dededdsss_fk_idx` (`combinazionelivdis`),
  CONSTRAINT `dededdsss_fk` FOREIGN KEY (`combinazionelivdis`) REFERENCES `disciplinedisponibili` (`Combinazionelivdis`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `mmmmmmmmm_fk` FOREIGN KEY (`modalitapagamento`) REFERENCES `modalitapagamento` (`NomeModalità`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ttttttttttt_fk` FOREIGN KEY (`tesserato`) REFERENCES `tesserato` (`Matricolatesserato`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iscrizionedisciplina`
--

LOCK TABLES `iscrizionedisciplina` WRITE;
/*!40000 ALTER TABLE `iscrizionedisciplina` DISABLE KEYS */;
INSERT INTO `iscrizionedisciplina` VALUES (15,'2017-04-02 07:50:22',5,'contanti',1),(18,'2017-04-02 07:51:57',5,'contanti',2),(20,'2017-04-02 07:52:44',6,'contanti',1),(21,'2017-04-02 07:52:44',6,'contanti',2),(23,'2017-04-02 07:53:05',7,'contanti',2),(24,'2017-04-02 07:53:06',8,'contanti',4),(25,'2017-04-02 07:53:06',8,'contanti',1);
/*!40000 ALTER TABLE `iscrizionedisciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iscrizionegara`
--

DROP TABLE IF EXISTS `iscrizionegara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iscrizionegara` (
  `CodiceIscrizioneGara` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DataAzione` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CertificatoRC` blob,
  `Gara` int(10) unsigned NOT NULL,
  `ModalitaPagamento` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Tesserato` int(10) unsigned NOT NULL,
  `Note` mediumtext CHARACTER SET utf8,
  PRIMARY KEY (`CodiceIscrizioneGara`,`Tesserato`,`ModalitaPagamento`,`Gara`),
  UNIQUE KEY `kjkkjkj` (`Gara`,`Tesserato`),
  KEY `tesserato_fk_idx` (`Tesserato`),
  KEY `attraverso(10)` (`ModalitaPagamento`),
  KEY `jhhhh_idx` (`Gara`),
  CONSTRAINT `attraverso(10)` FOREIGN KEY (`ModalitaPagamento`) REFERENCES `modalitapagamento` (`NomeModalità`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `effettua(11)` FOREIGN KEY (`Tesserato`) REFERENCES `tesserato` (`Matricolatesserato`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `jhhhh` FOREIGN KEY (`Gara`) REFERENCES `gara` (`CodiceGara`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iscrizionegara`
--

LOCK TABLES `iscrizionegara` WRITE;
/*!40000 ALTER TABLE `iscrizionegara` DISABLE KEYS */;
INSERT INTO `iscrizionegara` VALUES (19,'2017-04-02 08:47:58',NULL,5,'contanti',7,NULL),(20,'2017-04-02 08:47:59',NULL,5,'contanti',5,NULL),(21,'2017-04-02 08:47:59',NULL,6,'contanti',6,NULL),(22,'2017-04-02 08:47:59',NULL,6,'contanti',5,NULL);
/*!40000 ALTER TABLE `iscrizionegara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iscrizionestage`
--

DROP TABLE IF EXISTS `iscrizionestage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iscrizionestage` (
  `CodiceIscrizioneStage` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DataAzione` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Stage` int(10) unsigned NOT NULL,
  `ModalitaPagamento` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Tesserato` int(10) unsigned NOT NULL,
  `Note` mediumtext CHARACTER SET utf8,
  PRIMARY KEY (`CodiceIscrizioneStage`),
  UNIQUE KEY `jhigu` (`Stage`,`Tesserato`),
  KEY `tesserato2_fk_idx` (`Tesserato`),
  KEY `attraverso(13)` (`ModalitaPagamento`),
  KEY `dfsd_idx` (`Stage`),
  CONSTRAINT `attraverso(13)` FOREIGN KEY (`ModalitaPagamento`) REFERENCES `modalitapagamento` (`NomeModalità`) ON UPDATE CASCADE,
  CONSTRAINT `dfsd` FOREIGN KEY (`Stage`) REFERENCES `stage` (`CodiceStage`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `effettua(14)` FOREIGN KEY (`Tesserato`) REFERENCES `tesserato` (`Matricolatesserato`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iscrizionestage`
--

LOCK TABLES `iscrizionestage` WRITE;
/*!40000 ALTER TABLE `iscrizionestage` DISABLE KEYS */;
INSERT INTO `iscrizionestage` VALUES (1,'2017-04-02 09:02:56',3,'contanti',6,NULL),(2,'2017-04-02 09:02:57',3,'contanti',7,NULL),(3,'2017-04-02 09:02:57',4,'contanti',5,NULL),(4,'2017-04-02 09:02:57',4,'contanti',6,NULL);
/*!40000 ALTER TABLE `iscrizionestage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iscrizioniperturno`
--

DROP TABLE IF EXISTS `iscrizioniperturno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iscrizioniperturno` (
  `Codiceturnotesserato` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Codiceturno` int(10) unsigned NOT NULL,
  `Tesserato` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Codiceturnotesserato`,`Codiceturno`,`Tesserato`),
  UNIQUE KEY `erefes` (`Tesserato`,`Codiceturno`),
  KEY `FFVDVFFVFFFDB_idx` (`Codiceturno`),
  KEY `DSCDC_idx` (`Tesserato`),
  CONSTRAINT `DSCDC` FOREIGN KEY (`Tesserato`) REFERENCES `tesserato` (`Matricolatesserato`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FFVDVFFVFFFDB` FOREIGN KEY (`Codiceturno`) REFERENCES `gestioneturno` (`Codiceturno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iscrizioniperturno`
--

LOCK TABLES `iscrizioniperturno` WRITE;
/*!40000 ALTER TABLE `iscrizioniperturno` DISABLE KEYS */;
INSERT INTO `iscrizioniperturno` VALUES (4,1,5);
/*!40000 ALTER TABLE `iscrizioniperturno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `istruttore`
--

DROP TABLE IF EXISTS `istruttore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `istruttore` (
  `Matricolaistruttore` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `telefonoist` varchar(10) CHARACTER SET utf8 NOT NULL,
  `idutente` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Matricolaistruttore`,`idutente`),
  UNIQUE KEY `telefonoist_UNIQUE` (`telefonoist`),
  KEY `idut1_idx` (`idutente`),
  CONSTRAINT `idut1` FOREIGN KEY (`idutente`) REFERENCES `elencoutenti` (`idutente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `istruttore`
--

LOCK TABLES `istruttore` WRITE;
/*!40000 ALTER TABLE `istruttore` DISABLE KEYS */;
INSERT INTO `istruttore` VALUES (4,'0832657484',5),(5,'0832687454',6),(6,'0832956874',7);
/*!40000 ALTER TABLE `istruttore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `istruttoridisponibiliperdisciplina`
--

DROP TABLE IF EXISTS `istruttoridisponibiliperdisciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `istruttoridisponibiliperdisciplina` (
  `combinazioneistrdis` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `istruttore` int(10) unsigned NOT NULL,
  `combinazionelivdis` int(10) unsigned NOT NULL,
  PRIMARY KEY (`combinazioneistrdis`,`istruttore`,`combinazionelivdis`),
  UNIQUE KEY `cvvv` (`combinazionelivdis`,`istruttore`),
  KEY `KPKKOKO_idx` (`istruttore`),
  KEY `rgrrsrrttr_idx` (`combinazionelivdis`),
  CONSTRAINT `KPKKOKO` FOREIGN KEY (`istruttore`) REFERENCES `istruttore` (`Matricolaistruttore`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rgrrsrrttr` FOREIGN KEY (`combinazionelivdis`) REFERENCES `disciplinedisponibili` (`Combinazionelivdis`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `istruttoridisponibiliperdisciplina`
--

LOCK TABLES `istruttoridisponibiliperdisciplina` WRITE;
/*!40000 ALTER TABLE `istruttoridisponibiliperdisciplina` DISABLE KEYS */;
INSERT INTO `istruttoridisponibiliperdisciplina` VALUES (8,4,1),(9,4,5),(12,4,9),(13,5,2),(14,5,6),(15,5,10),(16,6,2),(17,6,6),(18,6,10);
/*!40000 ALTER TABLE `istruttoridisponibiliperdisciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livello`
--

DROP TABLE IF EXISTS `livello`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `livello` (
  `NomeLivello` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`NomeLivello`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livello`
--

LOCK TABLES `livello` WRITE;
/*!40000 ALTER TABLE `livello` DISABLE KEYS */;
INSERT INTO `livello` VALUES ('avanzato'),('esperto'),('intermedio'),('principiante');
/*!40000 ALTER TABLE `livello` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modalitapagamento`
--

DROP TABLE IF EXISTS `modalitapagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modalitapagamento` (
  `NomeModalità` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`NomeModalità`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modalitapagamento`
--

LOCK TABLES `modalitapagamento` WRITE;
/*!40000 ALTER TABLE `modalitapagamento` DISABLE KEYS */;
INSERT INTO `modalitapagamento` VALUES ('assegno circolare'),('bonifico bancario'),('carta di credito'),('contanti'),('gratuito');
/*!40000 ALTER TABLE `modalitapagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsabilecentro`
--

DROP TABLE IF EXISTS `responsabilecentro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `responsabilecentro` (
  `Matricolaresponsabile` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `telefonoresp` varchar(10) CHARACTER SET utf8 NOT NULL,
  `idutente` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Matricolaresponsabile`,`idutente`),
  UNIQUE KEY `telefonoresp_UNIQUE` (`telefonoresp`),
  KEY `idut2_idx` (`idutente`),
  CONSTRAINT `idut2` FOREIGN KEY (`idutente`) REFERENCES `elencoutenti` (`idutente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsabilecentro`
--

LOCK TABLES `responsabilecentro` WRITE;
/*!40000 ALTER TABLE `responsabilecentro` DISABLE KEYS */;
INSERT INTO `responsabilecentro` VALUES (0000000002,'0832547484',15);
/*!40000 ALTER TABLE `responsabilecentro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sceltaorariperiscrizione`
--

DROP TABLE IF EXISTS `sceltaorariperiscrizione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sceltaorariperiscrizione` (
  `preferenzafascia` enum('08:30-09:30','09:30-10:30','10:30-11:30','11:30-12:30','12:30-13:30','15:30-16:30','16:30-17:30','17:30-18:30','18:30-19:30','19:30-20:30','20:30-21:30') CHARACTER SET utf8 NOT NULL,
  `codiceiscrizionedisciplina` int(10) unsigned NOT NULL,
  UNIQUE KEY `bhhjvhj` (`preferenzafascia`,`codiceiscrizionedisciplina`),
  KEY `tesserasxddsto_fk_idx` (`codiceiscrizionedisciplina`),
  CONSTRAINT `tesserasxddsto_fk` FOREIGN KEY (`codiceiscrizionedisciplina`) REFERENCES `iscrizionedisciplina` (`codiceiscrizionedisciplina`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sceltaorariperiscrizione`
--

LOCK TABLES `sceltaorariperiscrizione` WRITE;
/*!40000 ALTER TABLE `sceltaorariperiscrizione` DISABLE KEYS */;
INSERT INTO `sceltaorariperiscrizione` VALUES ('08:30-09:30',15),('10:30-11:30',15),('17:30-18:30',18),('18:30-19:30',18),('08:30-09:30',20),('11:30-12:30',20),('18:30-19:30',21),('20:30-21:30',21),('08:30-09:30',23),('11:30-12:30',23),('20:30-21:30',23),('08:30-09:30',24),('19:30-20:30',24),('11:30-12:30',25),('12:30-13:30',25);
/*!40000 ALTER TABLE `sceltaorariperiscrizione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spazio`
--

DROP TABLE IF EXISTS `spazio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spazio` (
  `NomeSpazio` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`NomeSpazio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spazio`
--

LOCK TABLES `spazio` WRITE;
/*!40000 ALTER TABLE `spazio` DISABLE KEYS */;
INSERT INTO `spazio` VALUES ('piscina'),('sala cardio'),('sala fitness'),('sala gare 1'),('sala gare 2'),('sala gare 3'),('sala gare piscina'),('sala stage 1'),('sala stage 2'),('sala stage 3');
/*!40000 ALTER TABLE `spazio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stage`
--

DROP TABLE IF EXISTS `stage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stage` (
  `CodiceStage` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NomeEvento` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `DataEvento` date NOT NULL,
  `Descrizione` mediumtext COLLATE utf8_unicode_ci NOT NULL,
  `InfoPagamento` enum('Gratuito','A pagamento') COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Gratuito',
  `CostoEvento` float NOT NULL,
  `Istruttoredisp` int(10) unsigned NOT NULL,
  PRIMARY KEY (`CodiceStage`,`Istruttoredisp`),
  KEY ` mjnjj` (`Istruttoredisp`),
  CONSTRAINT ` mjnjj` FOREIGN KEY (`Istruttoredisp`) REFERENCES `istruttoridisponibiliperdisciplina` (`combinazioneistrdis`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stage`
--

LOCK TABLES `stage` WRITE;
/*!40000 ALTER TABLE `stage` DISABLE KEYS */;
INSERT INTO `stage` VALUES (3,'stage di pallavolo','2017-06-04','il seguente stage è per un livello principiante','A pagamento',15,16),(4,'stage di pallavolo','2017-06-10','il seguente stage è per un livello intermedio','A pagamento',20,14);
/*!40000 ALTER TABLE `stage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tesserato`
--

DROP TABLE IF EXISTS `tesserato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tesserato` (
  `Matricolatesserato` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idutente` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Matricolatesserato`,`idutente`),
  UNIQUE KEY `Indirizzomail_UNIQUE` (`idutente`),
  CONSTRAINT `idut` FOREIGN KEY (`idutente`) REFERENCES `elencoutenti` (`idutente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tesserato`
--

LOCK TABLES `tesserato` WRITE;
/*!40000 ALTER TABLE `tesserato` DISABLE KEYS */;
INSERT INTO `tesserato` VALUES (5,1),(6,2),(7,3),(8,4);
/*!40000 ALTER TABLE `tesserato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testimonianza`
--

DROP TABLE IF EXISTS `testimonianza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `testimonianza` (
  `CodiceTestimonianza` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Commento` mediumtext COLLATE utf8_unicode_ci NOT NULL,
  `DataAzione` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Tesserato` int(10) unsigned NOT NULL,
  `combinazionelivdis` int(10) unsigned NOT NULL,
  PRIMARY KEY (`CodiceTestimonianza`,`combinazionelivdis`,`Tesserato`),
  UNIQUE KEY `gvcbgbcgcb` (`Tesserato`,`combinazionelivdis`),
  KEY `inserisce(33)` (`Tesserato`),
  KEY `FFDFFSF_idx` (`combinazionelivdis`),
  CONSTRAINT `FFDFFSF` FOREIGN KEY (`combinazionelivdis`) REFERENCES `disciplinedisponibili` (`Combinazionelivdis`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `inserisce(33)` FOREIGN KEY (`Tesserato`) REFERENCES `tesserato` (`Matricolatesserato`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testimonianza`
--

LOCK TABLES `testimonianza` WRITE;
/*!40000 ALTER TABLE `testimonianza` DISABLE KEYS */;
INSERT INTO `testimonianza` VALUES (4,'bellissimooo','2017-04-02 09:30:17',5,1),(5,'mi sono divertito','2017-04-02 09:30:17',6,1),(6,'ottimo professore','2017-04-02 09:30:17',7,2);
/*!40000 ALTER TABLE `testimonianza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipologiaspazio`
--

DROP TABLE IF EXISTS `tipologiaspazio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipologiaspazio` (
  `NomeTipologia` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Spazio` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`NomeTipologia`),
  KEY `appartiene(35)` (`Spazio`),
  CONSTRAINT `appartiene(35)` FOREIGN KEY (`Spazio`) REFERENCES `spazio` (`NomeSpazio`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipologiaspazio`
--

LOCK TABLES `tipologiaspazio` WRITE;
/*!40000 ALTER TABLE `tipologiaspazio` DISABLE KEYS */;
INSERT INTO `tipologiaspazio` VALUES ('sala con attrezzi','sala cardio'),('sala adibita ad altri usi','sala gare 1'),('sala con attrezzi per agonisti','sala gare 2');
/*!40000 ALTER TABLE `tipologiaspazio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-02 11:57:54

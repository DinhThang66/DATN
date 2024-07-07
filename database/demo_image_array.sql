-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: demo
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `image_array`
--

DROP TABLE IF EXISTS `image_array`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image_array` (
  `image_id` bigint NOT NULL,
  `description` float DEFAULT NULL,
  KEY `FK4rludo0cw2d0mwkdiduihdvx6` (`image_id`),
  CONSTRAINT `FK4rludo0cw2d0mwkdiduihdvx6` FOREIGN KEY (`image_id`) REFERENCES `image` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image_array`
--

LOCK TABLES `image_array` WRITE;
/*!40000 ALTER TABLE `image_array` DISABLE KEYS */;
INSERT INTO `image_array` VALUES (314,-0.0891899),(314,0.0496173),(314,0.0965027),(314,-0.0292904),(314,-0.0134075),(314,-0.063275),(314,-0.0376666),(314,-0.0677076),(314,0.165878),(314,-0.116354),(314,0.269386),(314,0.061456),(314,-0.236758),(314,-0.00734078),(314,-0.0323575),(314,0.107693),(314,-0.225683),(314,-0.0118401),(314,-0.119399),(314,-0.0135751),(314,0.00237332),(314,0.0513786),(314,0.104476),(314,0.00528859),(314,-0.121876),(314,-0.330635),(314,-0.161897),(314,-0.0735511),(314,0.0877275),(314,-0.0798887),(314,-0.0177987),(314,-0.0379244),(314,-0.122842),(314,-0.0619759),(314,0.0176181),(314,0.0331182),(314,-0.0698899),(314,-0.0857301),(314,0.221306),(314,0.107184),(314,-0.149687),(314,0.0118675),(314,0.04409),(314,0.34926),(314,0.19465),(314,0.0882489),(314,0.0648109),(314,-0.0617115),(314,0.107417),(314,-0.27562),(314,0.101983),(314,0.0919568),(314,0.128277),(314,0.0512979),(314,0.182627),(314,-0.154859),(314,0.0602382),(314,0.191577),(314,-0.136405),(314,0.140902),(314,0.0696039),(314,0.0158507),(314,0.0637387),(314,0.0555102),(314,0.221036),(314,0.0712015),(314,-0.14215),(314,-0.104749),(314,0.106757),(314,-0.165088),(314,-0.0667814),(314,0.0516626),(314,-0.0725236),(314,-0.195334),(314,-0.280207),(314,-0.011976),(314,0.389453),(314,0.159948),(314,-0.188899),(314,0.0351655),(314,-0.100282),(314,-0.105158),(314,0.102793),(314,0.110385),(314,-0.114845),(314,0.0305146),(314,-0.153031),(314,-0.0724185),(314,0.228231),(314,0.0274513),(314,0.00219877),(314,0.288456),(314,0.0217856),(314,-0.0656634),(314,0.0618108),(314,-0.0140374),(314,-0.213788),(314,-0.0458695),(314,-0.145579),(314,-0.119824),(314,0.0504214),(314,-0.119303),(314,-0.0372399),(314,0.0834135),(314,-0.2764),(314,0.198755),(314,-0.0176094),(314,-0.0512402),(314,0.0464451),(314,-0.0106538),(314,-0.140295),(314,-0.00417328),(314,0.170057),(314,-0.277019),(314,0.140895),(314,0.214302),(314,0.0625589),(314,0.134953),(314,0.119671),(314,0.0355376),(314,-0.0166601),(314,0.0653861),(314,-0.10553),(314,-0.0994006),(314,-0.0325808),(314,-0.0681443),(314,0.0881673),(314,0.0041059),(315,-0.0974506),(315,0.181591),(315,0.0618356),(315,-0.0499345),(315,-0.170316),(315,-0.0325458),(315,-0.0495069),(315,-0.0996276),(315,0.0969586),(315,0.0493529),(315,0.266932),(315,0.00529433),(315,-0.217725),(315,-0.145155),(315,-0.0357544),(315,0.0981191),(315,-0.0906094),(315,-0.137836),(315,-0.0594994),(315,-0.0339947),(315,0.0318926),(315,-0.00391917),(315,0.0154319),(315,0.125094),(315,-0.0175585),(315,-0.275265),(315,-0.0112444),(315,-0.159257),(315,0.106514),(315,-0.236149),(315,-0.0564243),(315,0.0538855),(315,-0.173482),(315,-0.148168),(315,0.00000977889),(315,0.0703763),(315,-0.112551),(315,-0.157954),(315,0.258609),(315,-0.0371275),(315,-0.082597),(315,0.0124825),(315,0.0338413),(315,0.294657),(315,0.18177),(315,0.0147957),(315,0.0408529),(315,-0.0568201),(315,0.199844),(315,-0.202398),(315,0.0788513),(315,0.160694),(315,0.151691),(315,0.0924158),(315,0.0772452),(315,-0.20608),(315,0.0566407),(315,0.0902228),(315,-0.273056),(315,0.0912555),(315,0.0268327),(315,-0.080129),(315,-0.0459139),(315,-0.168652),(315,0.239168),(315,0.118265),(315,-0.0634707),(315,-0.117382),(315,0.13012),(315,-0.128106),(315,-0.0951061),(315,0.0833574),(315,-0.119946),(315,-0.113933),(315,-0.214525),(315,0.0558972),(315,0.26565),(315,0.16551),(315,-0.226201),(315,-0.00673661),(315,-0.0576678),(315,-0.0724308),(315,0.0055351),(315,0.0121054),(315,-0.0551476),(315,-0.060652),(315,-0.0982763),(315,-0.0623407),(315,0.170814),(315,0.0143624),(315,-0.00791866),(315,0.223438),(315,0.0299949),(315,0.00860846),(315,0.058792),(315,-0.0116862),(315,-0.092102),(315,0.0305387),(315,-0.0952366),(315,0.0478662),(315,-0.0455021),(315,-0.176452),(315,-0.0120241),(315,0.0277855),(315,-0.17405),(315,0.0657159),(315,0.0220097),(315,0.0597734),(315,-0.0628033),(315,-0.0814243),(315,-0.181015),(315,-0.0182554),(315,0.183445),(315,-0.293259),(315,0.328845),(315,0.123588),(315,0.0935095),(315,0.114536),(315,0.0807802),(315,0.0628774),(315,0.00785395),(315,-0.0960829),(315,-0.0942883),(315,-0.0829974),(315,0.123133),(315,-0.054333),(315,0.0204139),(315,0.0625252),(316,-0.113449),(316,0.173619),(316,0.0474984),(316,-0.0645316),(316,-0.156053),(316,0.0362316),(316,0.00159027),(316,-0.029225),(316,0.129463),(316,0.0659082),(316,0.20672),(316,-0.0610291),(316,-0.321038),(316,0.053498),(316,-0.0439239),(316,0.108168),(316,-0.155784),(316,-0.10978),(316,-0.133579),(316,-0.114918),(316,0.0227781),(316,-0.00182694),(316,-0.0444107),(316,0.12065),(316,-0.179373),(316,-0.226181),(316,0.012196),(316,-0.115744),(316,0.0409982),(316,-0.0730761),(316,0.0561686),(316,0.0080886),(316,-0.164926),(316,-0.0435937),(316,0.00548342),(316,0.0301817),(316,-0.0684016),(316,-0.131242),(316,0.256804),(316,-0.0734794),(316,-0.0775733),(316,0.0636189),(316,0.064274),(316,0.274376),(316,0.0795237),(316,0.0326201),(316,0.0954087),(316,-0.117877),(316,0.151345),(316,-0.197769),(316,0.0261339),(316,0.226512),(316,0.12328),(316,0.0435257),(316,0.00724183),(316,-0.233057),(316,0.0911658),(316,0.215594),(316,-0.247983),(316,0.130563),(316,0.0658504),(316,-0.0550055),(316,-0.0250615),(316,-0.141411),(316,0.230973),(316,0.0232528),(316,-0.149462),(316,-0.109104),(316,0.12876),(316,-0.0855625),(316,-0.0495688),(316,0.0466277),(316,-0.126236),(316,-0.185826),(316,-0.307569),(316,0.098123),(316,0.440712),(316,0.132169),(316,-0.242366),(316,0.0195573),(316,-0.0940797),(316,-0.0508192),(316,0.0050792),(316,0.0566588),(316,-0.17185),(316,-0.152243),(316,-0.177774),(316,-0.0035495),(316,0.215494),(316,0.0176262),(316,0.0367179),(316,0.189573),(316,0.129214),(316,-0.0715124),(316,-0.0295762),(316,0.0436251),(316,-0.248928),(316,-0.0107559),(316,-0.0407432),(316,0.0401336),(316,-0.0274399),(316,-0.13601),(316,-0.0157493),(316,0.0908118),(316,-0.230728),(316,0.170133),(316,0.0131671),(316,-0.0565975),(316,-0.0736931),(316,0.00828446),(316,-0.114723),(316,-0.0480914),(316,0.226893),(316,-0.253864),(316,0.124931),(316,0.151801),(316,0.122869),(316,0.162745),(316,0.10561),(316,0.108967),(316,-0.0301527),(316,0.0832528),(316,-0.181449),(316,-0.0860431),(316,0.0716002),(316,-0.102858),(316,0.0726674),(316,0.0987875),(317,-0.0510958),(317,0.143325),(317,-0.012169),(317,-0.130669),(317,-0.139101),(317,0.0575462),(317,-0.0715474),(317,-0.111095),(317,0.244126),(317,-0.0908664),(317,0.146983),(317,0.0301559),(317,-0.203204),(317,0.00639042),(317,-0.00629159),(317,0.0987581),(317,-0.204351),(317,-0.182178),(317,-0.0131432),(317,-0.00615194),(317,0.0431055),(317,-0.0170252),(317,-0.020163),(317,0.0889135),(317,-0.115196),(317,-0.338173),(317,-0.0517436),(317,-0.0138233),(317,0.0757528),(317,-0.0475534),(317,-0.0675577),(317,0.0866792),(317,-0.184972),(317,-0.0053978),(317,0.0671791),(317,0.235217),(317,-0.043052),(317,-0.113816),(317,0.175266),(317,0.02841),(317,-0.175305),(317,-0.00975964),(317,0.00798185),(317,0.277808),(317,0.260875),(317,-0.00945254),(317,0.0296115),(317,-0.0780472),(317,0.155825),(317,-0.262219),(317,0.114026),(317,0.197157),(317,0.0749173),(317,0.0665552),(317,0.105941),(317,-0.220846),(317,0.00476523),(317,0.0959456),(317,-0.17979),(317,-0.0314721),(317,0.0589761),(317,-0.0909483),(317,-0.00994421),(317,-0.174557),(317,0.202815),(317,0.1344),(317,-0.0761805),(317,-0.187954),(317,0.24152),(317,-0.132065),(317,-0.0732886),(317,0.0346055),(317,-0.110797),(317,-0.149324),(317,-0.22286),(317,0.0152822),(317,0.348342),(317,0.251027),(317,-0.190951),(317,0.0667542),(317,-0.0817855),(317,-0.0533473),(317,0.0151595),(317,0.04291),(317,0.00736871),(317,0.0253763),(317,-0.146243),(317,0.00960375),(317,0.229574),(317,-0.0022395),(317,0.00587133),(317,0.20203),(317,0.0158902),(317,-0.0370798),(317,0.0609042),(317,0.040025),(317,-0.14628),(317,0.0264021),(317,-0.252254),(317,-0.0983255),(317,-0.0336311),(317,-0.084598),(317,-0.0144993),(317,0.163382),(317,-0.256326),(317,0.185706),(317,0.000504957),(317,-0.0478637),(317,-0.0481838),(317,-0.0731459),(317,-0.097269),(317,-0.00420361),(317,0.197868),(317,-0.301142),(317,0.169822),(317,0.127301),(317,0.0961796),(317,0.206745),(317,0.0317138),(317,0.0884153),(317,0.0200775),(317,-0.113983),(317,-0.166395),(317,-0.106564),(317,-0.045033),(317,0.0104481),(317,-0.00215421),(317,0.106024),(2,-0.0378257),(2,0.102198),(2,0.0450468),(2,-0.0529471),(2,-0.142619),(2,-0.0237596),(2,-0.0735388),(2,-0.15164),(2,0.136695),(2,-0.0266088),(2,0.345958),(2,-0.105448),(2,-0.214417),(2,-0.112633),(2,-0.0719009),(2,0.173258),(2,-0.176334),(2,-0.136922),(2,0.0821632),(2,-0.00625668),(2,0.0672767),(2,-0.0253625),(2,-0.0120233),(2,0.0631384),(2,-0.0986852),(2,-0.323697),(2,-0.0591121),(2,-0.110562),(2,0.0737667),(2,-0.0860002),(2,-0.0726622),(2,0.103435),(2,-0.214754),(2,-0.0840685),(2,0.0468704),(2,0.0712782),(2,-0.0144972),(2,-0.0273962),(2,0.204415),(2,-0.035093),(2,-0.19548),(2,0.0336194),(2,0.0448169),(2,0.273955),(2,0.120153),(2,0.0191447),(2,0.0241962),(2,-0.176263),(2,0.0590233),(2,-0.10514),(2,0.0983899),(2,0.164561),(2,0.0985805),(2,0.0157562),(2,-0.036673),(2,-0.179493),(2,-0.0333555),(2,0.120867),(2,-0.201474),(2,0.0617676),(2,0.109262),(2,-0.0508909),(2,-0.00540644),(2,-0.15097),(2,0.281033),(2,0.0624516),(2,-0.09473),(2,-0.160231),(2,0.152123),(2,-0.0659185),(2,-0.0806837),(2,0.0612614),(2,-0.160312),(2,-0.155245),(2,-0.329485),(2,0.0420431),(2,0.374762),(2,0.0329883),(2,-0.220547),(2,0.066227),(2,-0.0452112),(2,-0.0567954),(2,0.101583),(2,0.104401),(2,0.00316511),(2,0.0162482),(2,-0.0854101),(2,0.00491829),(2,0.189536),(2,-0.0742969),(2,0.0160647),(2,0.202022),(2,-0.0641476),(2,0.0437303),(2,0.0362208),(2,0.0558395),(2,-0.0869854),(2,0.0567793),(2,-0.147925),(2,-0.0397369),(2,-0.0264179),(2,-0.0813405),(2,0.0202481),(2,0.154072),(2,-0.209724),(2,0.0551717),(2,0.0332021),(2,0.00113394),(2,0.0108344),(2,-0.0123981),(2,-0.0542632),(2,-0.108072),(2,0.16834),(2,-0.274825),(2,0.24838),(2,0.104781),(2,0.138443),(2,0.132382),(2,0.0830369),(2,0.0759166),(2,-0.0200982),(2,-0.0851421),(2,-0.191856),(2,0.0379503),(2,0.085201),(2,-0.0627464),(2,0.0780538),(2,0.0508511),(319,-0.0320674),(319,0.0484376),(319,0.00361725),(319,-0.119249),(319,-0.145488),(319,-0.0197764),(319,-0.0423236),(319,-0.00746376),(319,0.167425),(319,-0.111311),(319,0.189264),(319,-0.140873),(319,-0.289477),(319,0.0189935),(319,-0.0767849),(319,0.223226),(319,-0.201269),(319,-0.195795),(319,-0.084613),(319,0.0298277),(319,0.0777618),(319,0.0493166),(319,-0.0655358),(319,0.0737123),(319,-0.132097),(319,-0.362665),(319,-0.0824563),(319,-0.0799235),(319,-0.0908568),(319,-0.0833719),(319,-0.0170752),(319,-0.00200559),(319,-0.165137),(319,-0.0283255),(319,0.0607164),(319,0.0606578),(319,-0.0614112),(319,-0.168226),(319,0.1861),(319,0.0549212),(319,-0.340186),(319,0.0333831),(319,0.0896724),(319,0.270822),(319,0.153139),(319,0.00609659),(319,0.00464395),(319,-0.116383),(319,0.138192),(319,-0.256666),(319,0.000881092),(319,0.163953),(319,0.0515546),(319,0.0538503),(319,0.030641),(319,-0.101263),(319,0.0255946),(319,0.182878),(319,-0.188104),(319,-0.0172598),(319,0.106833),(319,-0.075152),(319,-0.0179317),(319,-0.152643),(319,0.212546),(319,0.049794),(319,-0.145502),(319,-0.201626),(319,0.167988),(319,-0.170027),(319,-0.104505),(319,0.102648),(319,-0.125565),(319,-0.241715),(319,-0.282811),(319,0.0236902),(319,0.3809),(319,0.157787),(319,-0.159786),(319,0.0684291),(319,-0.00396532),(319,0.0354295),(319,0.105963),(319,0.180612),(319,0.0544977),(319,0.0988461),(319,-0.131614),(319,0.0102876),(319,0.262396),(319,-0.10368),(319,-0.00215045),(319,0.235336),(319,0.00550816),(319,0.0300765),(319,0.0425921),(319,0.0217579),(319,-0.10152),(319,0.00230716),(319,-0.188011),(319,-0.000326643),(319,0.0381864),(319,0.0406734),(319,-0.0373953),(319,0.0976984),(319,-0.0697903),(319,0.0981821),(319,-0.0174856),(319,-0.0479173),(319,-0.0731959),(319,-0.032628),(319,-0.0576565),(319,-0.0766275),(319,0.131501),(319,-0.21119),(319,0.104715),(319,0.119361),(319,0.101417),(319,0.0957704),(319,0.120325),(319,0.0180689),(319,-0.0229086),(319,-0.0782776),(319,-0.278979),(319,-0.0432948),(319,0.0984786),(319,0.0288601),(319,0.101655),(319,-0.0300215),(318,-0.0864462),(318,0.0837799),(318,0.0208114),(318,-0.0721416),(318,-0.115197),(318,-0.00785031),(318,-0.0755873),(318,-0.0438138),(318,0.105328),(318,-0.127023),(318,0.187366),(318,-0.0472566),(318,-0.141882),(318,-0.0117359),(318,-0.0740011),(318,0.170464),(318,-0.101796),(318,-0.159865),(318,-0.0793946),(318,-0.0405484),(318,0.0245854),(318,0.141233),(318,-0.0789533),(318,0.0392687),(318,-0.115882),(318,-0.273828),(318,-0.0624612),(318,-0.0520077),(318,0.0321188),(318,-0.0785186),(318,-0.0190493),(318,0.0187596),(318,-0.202095),(318,-0.0226196),(318,0.0822229),(318,0.0733724),(318,-0.0210531),(318,-0.0223134),(318,0.206237),(318,0.0606304),(318,-0.261781),(318,0.0863109),(318,0.0740907),(318,0.320844),(318,0.181719),(318,0.027461),(318,-0.00646355),(318,-0.182018),(318,0.0993078),(318,-0.140588),(318,0.0581013),(318,0.155677),(318,0.0350189),(318,0.0837518),(318,-0.018826),(318,-0.109798),(318,0.03918),(318,0.114451),(318,-0.121298),(318,0.0373367),(318,0.101086),(318,-0.0436109),(318,-0.021552),(318,-0.0565093),(318,0.238368),(318,-0.015371),(318,-0.114839),(318,-0.252112),(318,0.121341),(318,-0.169874),(318,-0.140792),(318,0.119637),(318,-0.103067),(318,-0.15524),(318,-0.310673),(318,0.0872365),(318,0.439489),(318,0.153317),(318,-0.199387),(318,0.150565),(318,-0.00831569),(318,-0.0375029),(318,0.190063),(318,0.174747),(318,-0.0206183),(318,0.0358708),(318,-0.0321444),(318,0.0376443),(318,0.295187),(318,0.00223979),(318,-0.0661836),(318,0.176332),(318,0.00666427),(318,0.0637354),(318,0.0399137),(318,0.0394226),(318,-0.0761261),(318,0.0194018),(318,-0.132244),(318,-0.0626634),(318,0.0825471),(318,0.0307448),(318,0.0284091),(318,0.197838),(318,-0.154838),(318,0.227273),(318,-0.0147787),(318,0.0183857),(318,0.0174478),(318,0.0739363),(318,-0.0661242),(318,-0.0344314),(318,0.135134),(318,-0.194818),(318,0.225336),(318,0.102996),(318,0.103139),(318,0.0848482),(318,0.220311),(318,0.0564393),(318,0.0176393),(318,0.0190572),(318,-0.248632),(318,-0.0410276),(318,0.10519),(318,-0.0390447),(318,0.19481),(318,0.0283714),(327,-0.0644695),(327,0.0466414),(327,0.0564773),(327,-0.0590099),(327,-0.0582185),(327,-0.0158173),(327,-0.095415),(327,-0.131232),(327,0.118811),(327,-0.131377),(327,0.126337),(327,-0.0372612),(327,-0.187477),(327,-0.110478),(327,-0.00626344),(327,0.141852),(327,-0.163886),(327,-0.161677),(327,-0.056461),(327,0.00563175),(327,0.0829506),(327,0.0384828),(327,-0.0113825),(327,0.0177393),(327,-0.135899),(327,-0.290786),(327,-0.0923223),(327,-0.111372),(327,-0.0240037),(327,-0.0256312),(327,-0.153451),(327,-0.00105737),(327,-0.21229),(327,-0.0777491),(327,0.019963),(327,0.125608),(327,-0.0222209),(327,-0.0504978),(327,0.125149),(327,0.0361088),(327,-0.210739),(327,0.10179),(327,0.0202772),(327,0.210492),(327,0.192964),(327,0.0672474),(327,-0.0141735),(327,-0.127091),(327,0.172995),(327,-0.133212),(327,0.0748548),(327,0.18233),(327,0.104911),(327,0.117329),(327,0.00511202),(327,-0.121439),(327,0.0907386),(327,0.0792564),(327,-0.139699),(327,0.0496124),(327,0.0977743),(327,-0.071847),(327,-0.0144177),(327,-0.0457097),(327,0.171909),(327,0.0438671),(327,-0.0770249),(327,-0.190116),(327,0.0825459),(327,-0.132305),(327,-0.114746),(327,0.0334719),(327,-0.187768),(327,-0.156146),(327,-0.263327),(327,0.0279966),(327,0.330313),(327,0.120252),(327,-0.258103),(327,0.0478852),(327,-0.0456816),(327,-0.015006),(327,0.169704),(327,0.15322),(327,0.0484392),(327,0.0487073),(327,-0.0794614),(327,-0.0167732),(327,0.230537),(327,-0.0682688),(327,0.00553513),(327,0.232699),(327,0.0278888),(327,0.0699726),(327,0.042795),(327,-0.000538513),(327,-0.0731944),(327,0.0420719),(327,-0.127776),(327,-0.0350753),(327,0.067561),(327,-0.0273103),(327,-0.0340918),(327,0.104039),(327,-0.138415),(327,0.160077),(327,0.00661945),(327,0.0499327),(327,0.0222538),(327,-0.039056),(327,-0.0960583),(327,-0.083316),(327,0.120746),(327,-0.172688),(327,0.205623),(327,0.188022),(327,0.0624056),(327,0.0811369),(327,0.0977411),(327,0.0971948),(327,-0.0227027),(327,0.0251713),(327,-0.244096),(327,-0.049181),(327,0.123124),(327,0.0114103),(327,0.0633817),(327,0.0213813),(328,-0.0669102),(328,0.000663998),(328,0.0587103),(328,-0.0813152),(328,-0.126665),(328,-0.0164279),(328,-0.0721273),(328,-0.101023),(328,0.0902096),(328,-0.153166),(328,0.181551),(328,-0.0666284),(328,-0.166659),(328,-0.0632746),(328,-0.0458597),(328,0.189979),(328,-0.168108),(328,-0.177676),(328,-0.0633557),(328,-0.0182232),(328,0.0665432),(328,0.0481105),(328,0.018602),(328,0.0722215),(328,-0.183571),(328,-0.332544),(328,-0.0689658),(328,0.00370682),(328,-0.0516788),(328,-0.072017),(328,-0.0931606),(328,0.0887203),(328,-0.2377),(328,0.00743868),(328,0.0187964),(328,0.145232),(328,-0.0109946),(328,-0.0891922),(328,0.169377),(328,0.0411338),(328,-0.284508),(328,0.103007),(328,0.0583789),(328,0.200625),(328,0.169218),(328,0.00322356),(328,-0.000919677),(328,-0.135226),(328,0.115843),(328,-0.179384),(328,0.0715761),(328,0.170121),(328,0.0611308),(328,0.0480103),(328,-0.0216345),(328,-0.122922),(328,-0.0000688024),(328,0.130809),(328,-0.106433),(328,-0.0201838),(328,0.0452665),(328,-0.0803341),(328,0.00313334),(328,-0.180101),(328,0.147962),(328,0.116877),(328,-0.0723631),(328,-0.248563),(328,0.104683),(328,-0.16213),(328,-0.135976),(328,0.0806491),(328,-0.141739),(328,-0.170801),(328,-0.328064),(328,0.0146096),(328,0.272935),(328,0.12925),(328,-0.226389),(328,0.0578145),(328,0.0176788),(328,0.00806162),(328,0.116889),(328,0.172262),(328,0.0176793),(328,0.0914545),(328,-0.0669259),(328,0.0196592),(328,0.247367),(328,-0.0288021),(328,-0.0517783),(328,0.209751),(328,0.0266748),(328,0.0674271),(328,0.0676157),(328,0.00116416),(328,-0.0762471),(328,0.0554446),(328,-0.15973),(328,0.0295136),(328,-0.0108641),(328,0.00773553),(328,-0.0275264),(328,0.130497),(328,-0.115561),(328,0.171596),(328,-0.061087),(328,-0.0222075),(328,-0.0170916),(328,0.00864785),(328,-0.0909993),(328,-0.0760497),(328,0.0923615),(328,-0.225577),(328,0.166385),(328,0.173937),(328,0.0709677),(328,0.130751),(328,0.134953),(328,0.120933),(328,-0.0404537),(328,0.0404635),(328,-0.232183),(328,-0.00769804),(328,0.146765),(328,-0.0647312),(328,0.109729),(328,0.0298671),(329,-0.163022),(329,0.0793063),(329,-0.0393828),(329,-0.0152073),(329,-0.144184),(329,0.0095859),(329,0.00626509),(329,-0.0581193),(329,0.0749853),(329,-0.114998),(329,0.284307),(329,-0.0746942),(329,-0.305515),(329,-0.0876157),(329,-0.00288675),(329,0.156094),(329,-0.110397),(329,-0.143763),(329,-0.149105),(329,-0.089609),(329,-0.0122458),(329,0.0233259),(329,-0.0391848),(329,0.0785136),(329,-0.190948),(329,-0.224944),(329,-0.00809391),(329,-0.133625),(329,0.0261019),(329,-0.148663),(329,0.0465414),(329,0.0500106),(329,-0.155619),(329,-0.0373571),(329,0.00558231),(329,0.0863723),(329,-0.112797),(329,-0.0305681),(329,0.301075),(329,0.0553611),(329,-0.18873),(329,-0.0007182),(329,0.0507592),(329,0.350745),(329,0.138506),(329,-0.00297262),(329,0.0280234),(329,-0.00768612),(329,0.117801),(329,-0.345093),(329,0.0303863),(329,0.148012),(329,0.18589),(329,0.127584),(329,-0.0374997),(329,-0.144286),(329,0.0662344),(329,0.160594),(329,-0.299212),(329,0.100031),(329,0.0752819),(329,-0.112933),(329,-0.0944443),(329,0.0196829),(329,0.259848),(329,0.122841),(329,-0.139292),(329,-0.140155),(329,0.155448),(329,-0.208469),(329,-0.099582),(329,0.184739),(329,-0.0898784),(329,-0.239409),(329,-0.275628),(329,0.125163),(329,0.399934),(329,0.188112),(329,-0.132608),(329,-0.0110856),(329,0.003009),(329,-0.0523179),(329,0.0511119),(329,0.0793522),(329,-0.0709209),(329,-0.0737585),(329,-0.0441646),(329,0.0454014),(329,0.209551),(329,-0.0333614),(329,-0.0553236),(329,0.236251),(329,0.118572),(329,-0.0366815),(329,0.0423625),(329,0.0330449),(329,-0.0211299),(329,-0.0680362),(329,-0.0330494),(329,0.0130516),(329,0.0498117),(329,-0.124188),(329,0.0499181),(329,0.0132441),(329,-0.155448),(329,0.246773),(329,-0.0364143),(329,-0.0402878),(329,-0.042277),(329,-0.00507562),(329,-0.0832324),(329,0.0133957),(329,0.165426),(329,-0.291516),(329,0.222172),(329,0.188031),(329,0.0731012),(329,0.128721),(329,0.115917),(329,0.0270338),(329,0.0320545),(329,0.0113223),(329,-0.134304),(329,-0.143995),(329,0.0898877),(329,-0.0595317),(329,0.113754),(329,0.00401546),(330,-0.085309),(330,0.105981),(330,0.00976612),(330,-0.0626281),(330,-0.0875267),(330,-0.00124516),(330,0.0361358),(330,-0.0839485),(330,0.216482),(330,-0.1669),(330,0.133673),(330,0.0145801),(330,-0.202523),(330,-0.0247471),(330,-0.0187506),(330,0.0955268),(330,-0.12853),(330,-0.207622),(330,-0.160948),(330,-0.160754),(330,0.0347572),(330,0.076362),(330,-0.0744778),(330,0.0950516),(330,-0.0864366),(330,-0.234452),(330,-0.111325),(330,-0.0655803),(330,0.11318),(330,-0.101604),(330,0.0051277),(330,0.0480607),(330,-0.127409),(330,-0.0347286),(330,0.017703),(330,0.0513104),(330,-0.0520427),(330,-0.169266),(330,0.263614),(330,0.0260724),(330,-0.131346),(330,-0.0391334),(330,0.0541943),(330,0.321871),(330,0.114808),(330,-0.00904786),(330,0.0137505),(330,-0.0112132),(330,0.22109),(330,-0.271991),(330,0.0801099),(330,0.156989),(330,0.201888),(330,0.0740846),(330,0.11938),(330,-0.177808),(330,0.0341286),(330,0.168221),(330,-0.229966),(330,0.149234),(330,-0.00932182),(330,-0.171373),(330,-0.0794045),(330,-0.0757677),(330,0.191342),(330,0.143065),(330,-0.115022),(330,-0.150599),(330,0.221463),(330,-0.176021),(330,-0.0775878),(330,0.139907),(330,-0.10595),(330,-0.149931),(330,-0.254892),(330,0.0554052),(330,0.517353),(330,0.194689),(330,-0.123942),(330,-0.00736167),(330,-0.00928846),(330,-0.060718),(330,0.0690345),(330,0.136476),(330,-0.163892),(330,-0.0680728),(330,-0.10328),(330,0.0818975),(330,0.249366),(330,0.0655892),(330,-0.158711),(330,0.189738),(330,0.0456601),(330,0.0292725),(330,-0.0394057),(330,0.0109676),(330,-0.0528389),(330,-0.0633719),(330,-0.0566206),(330,0.0250742),(330,0.0703807),(330,-0.0636313),(330,-0.067748),(330,0.121845),(330,-0.119757),(330,0.137175),(330,-0.00174773),(330,-0.0260999),(330,-0.0805072),(330,-0.0262285),(330,-0.158902),(330,0.0489149),(330,0.153992),(330,-0.266569),(330,0.118024),(330,0.140528),(330,0.0386266),(330,0.138736),(330,0.0229165),(330,0.00619297),(330,0.0802273),(330,-0.130706),(330,-0.200246),(330,-0.136402),(330,0.105943),(330,-0.0389051),(330,0.0781015),(330,0.033606),(331,-0.124231),(331,0.191217),(331,-0.0496333),(331,0.00742472),(331,-0.0412812),(331,-0.0247942),(331,-0.0274194),(331,-0.052438),(331,0.222384),(331,-0.0211169),(331,0.185042),(331,-0.0477685),(331,-0.191322),(331,-0.0298972),(331,-0.134998),(331,0.0839877),(331,-0.227861),(331,-0.0916134),(331,-0.0534634),(331,-0.0452852),(331,0.0755773),(331,0.0546541),(331,0.00360694),(331,0.0771838),(331,-0.177324),(331,-0.310538),(331,-0.0984424),(331,-0.074602),(331,0.126834),(331,-0.0906656),(331,0.0427524),(331,0.0570916),(331,-0.195214),(331,-0.0605333),(331,0.007492),(331,0.0165313),(331,-0.0990159),(331,-0.0606176),(331,0.233228),(331,0.0135896),(331,-0.0746642),(331,0.0272548),(331,0.0601903),(331,0.360683),(331,0.134984),(331,0.0620381),(331,0.00254107),(331,-0.0787781),(331,0.104487),(331,-0.224931),(331,0.0533962),(331,0.178328),(331,0.143642),(331,0.110926),(331,0.0998562),(331,-0.156835),(331,0.0118912),(331,0.17432),(331,-0.25945),(331,0.13111),(331,0.000241529),(331,0.0175274),(331,0.00072127),(331,-0.082402),(331,0.122744),(331,0.0933402),(331,-0.0467415),(331,-0.154474),(331,0.18581),(331,-0.218741),(331,0.0283874),(331,0.163041),(331,-0.00342073),(331,-0.288718),(331,-0.223223),(331,0.0611627),(331,0.336129),(331,0.279321),(331,-0.0409088),(331,0.0267976),(331,0.0481844),(331,-0.103449),(331,0.0601768),(331,-0.0291715),(331,-0.202895),(331,-0.0503715),(331,-0.0772997),(331,0.0703257),(331,0.209493),(331,0.0742068),(331,-0.084933),(331,0.223481),(331,0.0312743),(331,-0.0509898),(331,-0.00732025),(331,-0.0639729),(331,-0.0980947),(331,0.0551355),(331,-0.108714),(331,0.0482091),(331,0.00758651),(331,-0.10937),(331,-0.0031914),(331,0.0589831),(331,-0.109097),(331,0.105486),(331,0.0207302),(331,-0.0556114),(331,-0.0899172),(331,0.0433404),(331,-0.229868),(331,0.03356),(331,0.202719),(331,-0.29906),(331,0.231912),(331,0.112234),(331,0.0851491),(331,0.172607),(331,0.0693517),(331,0.0304748),(331,0.0296487),(331,-0.0592574),(331,-0.104288),(331,-0.0787448),(331,0.0978206),(331,-0.100609),(331,0.11088),(331,-0.00232394);
/*!40000 ALTER TABLE `image_array` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-07 20:48:23
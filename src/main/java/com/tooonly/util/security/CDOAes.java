package com.tooonly.util.security;


import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;
import java.util.concurrent.atomic.AtomicLong;

public class CDOAes extends AES {
    private Cipher[] encoders;
    private Cipher[] decoders;
    private int nInstanceCount;
    private AtomicLong alEncodeIndex;
    private AtomicLong alDecodeIndex;

    public CDOAes() {
        this(1);
        init();
    }

    public CDOAes(int nInstanceCount) {
        this.encoders = null;
        this.decoders = null;
        this.nInstanceCount = 1;
        this.alEncodeIndex = null;
        this.alDecodeIndex = null;
        this.nInstanceCount = nInstanceCount;
        this.encoders = new Cipher[nInstanceCount];
        this.decoders = new Cipher[nInstanceCount];
        this.alEncodeIndex = new AtomicLong(0L);
        this.alDecodeIndex = new AtomicLong(0L);
    }

    public void init(String strPassword) {
        String[] strsItem = AES.splitString(strPassword, '|');
        if (strsItem.length != 2) {
            throw new RuntimeException("Invalid AES password: " + strPassword);
        } else {
            this.init(strsItem[0], strsItem[1]);
        }
    }

    public void init(){
        init("hQFmTvJ3lqwfB1xW", "kpPnCaOljeWCamnrY16Y7MeIKoogfQYN");
    }

    public void init(String strKey, String strIV) {
        if (strKey.length() < 16) {
            throw new RuntimeException("Key length must be at least 16");
        } else if (strIV.length() < 16) {
            throw new RuntimeException("IV length must be at least 16");
        } else {
            try {
                strKey = strKey.substring(0, 16);
                strIV = strIV.substring(0, 16);
                byte[] keyBytes = strKey.getBytes("utf-8");
                Security.addProvider(new BouncyCastleProvider());
                SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
                byte[] bysIV = strKey.getBytes("utf-8");
                IvParameterSpec iv = new IvParameterSpec(bysIV);

                for(int i = 0; i < this.nInstanceCount; ++i) {
                    this.encoders[i] = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
                    this.encoders[i].init(1, key, iv);
                    this.decoders[i] = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
                    this.decoders[i].init(2, key, iv);
                }

            } catch (Exception var8) {
                for(int i = 0; i < this.nInstanceCount; ++i) {
                    this.encoders[i] = null;
                    this.decoders[i] = null;
                }

                throw new RuntimeException(var8);
            }
        }
    }

    public byte[] encode(byte[] bysContent) {
        int nIndex = (int)(this.alEncodeIndex.incrementAndGet() % (long)this.nInstanceCount);
        if (this.encoders[nIndex] == null) {
            return bysContent;
        } else {
            try {
                byte[] bysResult = null;
                synchronized(this.encoders[nIndex]) {
                    bysResult = this.encoders[nIndex].doFinal(bysContent);
                }

                return bysResult;
            } catch (Exception var6) {
                throw new RuntimeException(var6);
            }
        }
    }

    public String encode(String strText) {
        int nIndex = (int)(this.alEncodeIndex.incrementAndGet() % (long)this.nInstanceCount);
        if (this.encoders[nIndex] == null) {
            return strText;
        } else {
            try {
                byte[] byteContent = strText.getBytes("utf-8");
                byte[] bysResult = null;
                synchronized(this.encoders[nIndex]) {
                    bysResult = this.encoders[nIndex].doFinal(byteContent);
                }

                String strResult = Base64.encode(bysResult);
                return strResult;
            } catch (Exception var7) {
                throw new RuntimeException(var7);
            }
        }
    }

    public byte[] decode(byte[] bysEncoded) {
        int nIndex = (int)(this.alDecodeIndex.incrementAndGet() % (long)this.nInstanceCount);
        if (this.decoders[nIndex] == null) {
            return bysEncoded;
        } else {
            try {
                byte[] bysResult = null;
                synchronized(this.decoders[nIndex]) {
                    bysResult = this.decoders[nIndex].doFinal(bysEncoded);
                }

                return bysResult;
            } catch (Exception var6) {
                throw new RuntimeException(var6);
            }
        }
    }

    public String decode(String strEncoded) {
        int nIndex = (int)(this.alDecodeIndex.incrementAndGet() % (long)this.nInstanceCount);
        if (this.decoders[nIndex] == null) {
            return strEncoded;
        } else {
            byte[] bysEncoded = Base64.decode(strEncoded);

            try {
                byte[] bysResult = null;
                synchronized(this.decoders[nIndex]) {
                    bysResult = this.decoders[nIndex].doFinal(bysEncoded);
                }

                String strResult = new String(bysResult, "utf-8");
                return strResult;
            } catch (Exception var7) {
                throw new RuntimeException(var7);
            }
        }
    }

    public static void main(String[] args) {
        AES aes = new CDOAes();
        String content = "110102198411081184,120221198907053212,130121199404011089,13012419850102453X,130124199112212726,130181198702285717,130181198910037144,130202198603120327,130203198611190612,130203199309221822,130205198711070039,13020619800920032X,130206199408220365,130221195908050011,130221196904145325,130221197705160068,130221197712190054,130221198109230925,130221198401116820,130221198710270127,130221198801200079,130221198807055925,13022119901128513X,130221199602240013,130221199706033414,130223198811230311,130223199101075219,130223199303214926,13022419900520761X,130224199006273045,130224199012023085,130225198203147429,13022619680713567X,130227196605066625,130227197007163825,130229197603272027,130281198904023729,130281198907173714,130282198903293125,130282199302152655,130302193902090028,130302195007042248,130302195207083511,130302195402182216,130302195510222561,130302195612121825,130302196207041148,130302196505160022,130302197206153927,130302197304290028,130302197503234520,130302198107103312,130302198501245423,130302198506181617,130302199312253525,130302199503131424,130302199903162529,130302201111021111,130303198811261222,130303199009070044,130303199201310319,130304198412122029,130304199103072034,130321196410191626,130321198901047839,130322195801231033,13032219720706442X,130322197403014024,130322197409203619,130322197902261011,130322198912063523,130322199101061019,130323196202231411,130323196207233221,130323196502250622,130323196811244226,130323197004101442,130323198303082426,130323198509054412,130323198706100246,130323198801156424,130323199007150812,130324196611070328,130324198005150618,130324198505287522,130324198508052112,130324198706040040,130324198802280941,130324199110144513,130402194107141527,130402198103141827,130402198709151245,130403198508123316,130403198810201821,130404196002271511,130404198206211819,130406198205071837,130406198603061810,130421198302275712,130421198309125725,130421198502103632,130421198503125745,130421198705032125,130421198807163628,130427198507016923,130427198706182721,130429197811011711,130429198410067321,130429198502081243,130429198711154461,13042919891103005X,13042919901018526X,130429199107165214,130429199308044013,13042919940911341X,130502198001181225,130502198906131855,130503196508090936,130503198703110321,130523198607242426,130523199403092432,130525198511025139,130525198608190042,130529197403243017,130529198706260660,130529199303294641,130531199008013247,130533198511161018,130533198911280534,130629199004101024,130629199009161034,130635198409020022,130635198903150068,130702195905030638,130702196403170643,130702196411070028,130702199204162126,130703198108090013,130704195502260925,130704196102090343,130705199205201229,130705199406072128,130721199306245124,130721199602125813,130722199009038328,130722199308051127,130723198801104554,130725199510280889,13072819880517552X,130728198807316015,130731199202062422,130804198002081022,130821195503235862,130821198207120319,130821198303015869,130824198611011578,130825198905105744,130902198606073624,130921196502172417,130921196610202433,130921197506023448,130921198908064167,130921199112233249,13092119921010001X,130922196505012028,130922196910146900,130922197503214026,130922197801096443,13092219860906602X,130922198702213610,130922198707176812,130922198707286835,13092219871215524X,130922198802010132,130922198808051656,130922198810050038,130922199101177233,130922199101180037,130922199105220016,13092219910623521X,130922199204082042,13092219920410001X,13092219920429001X,130922199206061229,13092219920613001X,130922199301280016,130922199302140015,13092219930528003X,13092219930725082X,130922199311061239,130922199406053223,130922199507020033,130922199708080817,130922199806120042,130925198711275230,130925199506245248,130929198504015415,130930198804230913,130981198403055624,130982198512280026,130982198712150015,130982199002012333,130983198701252442,130983198803044513,130984198103102475,131002198804200614,131002199212220616,131022198707190077,13102419901026722X,131025198702284831,131025198905100043,131025198907095129,131121195908195021,131121199403200022,131121199405040018,131181198509040778,131181199104061516,131181199105110762,131181199110020040,132226196911290372,132235197112156143,13252119560114381X,132521196810210083,132524195403240810,13252419560212082X,132525197107303122,132526196309121062,132526197804173104,132626195410091567,132628198102101221,132924196304078463,132928195512064526,132931198104100921,13293219550909530X,132932196307173626,132932196604170034,132932196804280027,132932198807143625,14041119580418084X,141181196612160105,141181198608250035,141181199005180140,141181199207260173,142301198401084527,142301198501194512,142301198809105416,142301199008310027,142301199202125423,142430199308252022,142601198705122621,142625196207161910,142632199005185049,142701195809220623,142702199402090948,142724198702211610,142725198605096442,150103199308141124,150123198811263146,150123198904126036,150123199102165097,15030219771011252X,150304197711132031,152201196408293046,15220119781026052X,152326199305214612,152527198607232122,152527199005083929,152527199101032128,210122198506275124,210124198203100119,210181198606072762,210302198607250028,21030319860329162X,210303199906092921,210304198511191011,210311198808270910,210311198902180014,210311199003241527,210311199605080927,210321196511230620,210321198411250631,210321198510060622,210321198609260624,210381198809233811,210381198809253513,210701198605249424,210719195910290247,210719196204245427,210719197402223215,210723195502280220,210723196610095289,210724198207064023,210726199103113748,210727199009125415,210781198812224029,210782199705020013,210902198401193040,210921198202201668,211022199006303918,211102195302080570,211102198206251038,211102198306072520,211102198705182022,211103199010252750,211121197404023647,211121198705152447,211121199010231813,211122198604142414,21112219880805001X,211122199001151973,21112219950324001X,211202196310032026,21122319920529162X,211302197910091222,211302198307300012,211302198410254042,211302200005193223,211303198003130460,211303198804263634,211303199105133616,211303199507123613,211319195610121424,211321198712075815,211321199008108286,211322197205027028,211381198504290015,211402198409200843,211402198702181944,211402199005095412,211402199201125957,211402200008050047,211403198706308216,211404198307183416,211421196902210025,211421197703100100,211421198108101410,211421198602230621,211421198807112629,211421199202220226,211421199210036226,211421199212201029,21142119930827621X,211421199310065833,211481198106060228,211481199002275229,211481199211053913,211481199302244029,211481199303163925,211481199307140421,220503197507210728,220881196910106825,230102198809103715,231002196012182723,231003199602022914,231004195910140013,231004196202180027,231005198806290513,231011196211150616,231027196408230020,231083197907093660,320103198306072265,320104198808022010,320706198807081014,320721199208212279,320721199310042640,32072219880730605X,320722199204301625,320723198701174454,320723199110220679,321081198503165131,321088198912031550,340103198806052512,340111199305210513,340121199106051014,34032119960912831X,340323199211306940,340406199204123432,340602199407092416,340825198903094366,341125199304043441,341225198705252739,341227199003168732,341227199103201050,34220119700116324X,342201197212130843,342201197609144426,342201198201023369,342201198412063264,34220119841209495X,34220119880130325X,342423198706254217,342501199308110543,342529199411280045,342622198904012141,342622199101107117,342623199207117512,360781198910073634,370226196808155562,370281198208103527,370281198805115315,370284199210153631,370481199108255617,370481199610087735,370602195308010443,370602195804064942,370602196408094925,370628198005235546,370682198211303560,370686199411272578,370686199412242514,370686199512262512,37082619961128747X,370826199710251616,370881198310280311,370882197909296127,37088219841127614X,37088219861218003X,370911199312230415,371302199101154637,371323198809217215,371325198904302322,37132519900103232X,371402199511220620,371522198812130510,372324199011293210,372401197001191028,372425194907117622,372502198307200501,372901198409113949,372922197105215484,410425198804220511,411222198308250528,411329198007120017,412726199508215418,420114198310174558,420523197910150094,422103197202050521,422201198807172238,422432198108163047,431002198512311014,45262319930101331X,511002198103293628,51130319880907135X,530324198412121122,530324198908161128,532701199302230073,532722198307020021,532723199101262448,532725198212251547,532726199008060621,532729197601021228,532729198708113944,532801197407050841,532801197410042770,53280119830919271X,532801198610010823,532801198709150535,532801198901230041,532801198912283421,532801199001142112,532801199207063428,532822197401271020,53282219880715008X,532823197208220025,532823198403150071,532901196810102622,533223199203062125,533521198802263622,533523198612211621,610502197608075816,61212519630215102X,612725198803185027,620502196103020710,620502197102250025,620502198507133331,620502199607140760";
        StringBuilder sb = new StringBuilder("'");
        for(String str:content.split(",")){
            sb.append(aes.encode(str)).append("','");
        }
        System.out.println(sb);
    }
}


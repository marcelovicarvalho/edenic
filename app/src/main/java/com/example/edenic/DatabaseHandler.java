package com.example.edenic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context){super(context,"Edenic",null,1);}
    //database version
    private static final int DATABASE_VERSION = 1;

    //database name
    private static final String DATABASE_SPELL = "feiticos.db";
    private static final String DATABASE_CHAR = "personagens.db";
    private static final String DATABASE_PROF = "proficiencia.db";

    //Table name
    private static final String TABLE_SPELLS = "feiticos";
    private static final String TABLE_CHAR = "personagens";
    private static final String TABLE_PROF = "proficiencias";

    //table feiticos fields
    private static final String SPELL_ID = "id";
    private static final String SPELL_NAME = "name";
    private static final String SPELL_NIVEL = "nivel";
    private static final String SPELL_CAST_TIME = "castTime";
    private static final String SPELL_RANGE = "range";
    private static final String SPELL_DURATION = "duration";
    private static final String SPELL_CLASSE = "classe";
    private static final String SPELL_DESC = "descricao";

    //table personagens fields
    private static final String CHAR_ID = "char_id";
    private static final String CHAR_NAME = "char_nome";
    private static final String CHAR_NIVEL = "char_nivel";
    private static final String CHAR_RACA = "char_raca";
    private static final String CHAR_CLASS = "char_class";
    private static final String CHAR_BACK = "char_back";
    private static final String CHAR_STR = "char_str";
    private static final String CHAR_DEX = "char_dex";
    private static final String CHAR_CONS = "char_cons";
    private static final String CHAR_INT = "char_int";
    private static final String CHAR_WIS = "char_wis";
    private static final String CHAR_CHAR = "char_char";
    private static final String CHAR_HP = "char_hp";
    private static final String CHAR_DESC = "char_desc";

    //table personagens fields
    private static final String PROF_ID = "prof_id";
    private static final String PROF_ATL = "prof_atl";
    private static final String PROF_ACR = "prof_acr";
    private static final String PROF_FURT = "prof_furt";
    private static final String PROF_PREST = "prof_prest";
    private static final String PROF_ARC = "prof_arc";
    private static final String PROF_HIS = "prof_his";
    private static final String PROF_INVES = "prof_inves";
    private static final String PROF_NATU = "prof_natu";
    private static final String PROF_RELI = "prof_reli";
    private static final String PROF_ADES = "prof_ades";
    private static final String PROF_INTUI = "prof_intui";
    private static final String PROF_MEDIC = "prof_medic";
    private static final String PROF_PERCEP = "prof_percep";
    private static final String PROF_SOBRE = "prof_sobre";
    private static final String PROF_ATUA = "prof_atua";
    private static final String PROF_ENGANA = "prof_engana";
    private static final String PROF_INTI = "prof_inti";
    private static final String PROF_PERSU = "prof_persu";

@Override
    public void onCreate(SQLiteDatabase db) {
        //banco feiticos
        db.execSQL("CREATE TABLE IF NOT EXISTS "
                +TABLE_SPELLS+ "( "
                +SPELL_ID + " "+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +SPELL_NAME+ " VARCHAR(255) NOT NULL,"
                +SPELL_NIVEL+ " int(2) NOT NULL, "
                +SPELL_CAST_TIME+ " varchar(255) DEFAULT NULL, "
                +SPELL_RANGE+ " VARCHAR(255) DEFAULT NULL, "
                +SPELL_DURATION+ " VARCHAR(255) DEFAULT NULL, "
                +SPELL_CLASSE+ " VARCHAR(255) NOT NULL, "
                +SPELL_DESC+ " VARCHAR(255) NOT NULL "
                + ")");



        //banco Personagens
        db.execSQL("CREATE TABLE IF NOT EXISTS "
                +TABLE_CHAR+ " ( "
                +CHAR_ID + " "+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +CHAR_NAME+ " VARCHAR(255) NOT NULL,"
                +CHAR_NIVEL+ " int(2) NOT NULL, "
                +CHAR_RACA+ " VARCHAR(255) NOT NULL, "
                +CHAR_CLASS+ " VARCHAR(255) NOT NULL, "
                +CHAR_BACK+ " VARCHAR(255) NOT NULL, "
                +CHAR_STR+ " int(2) NOT NULL, "
                +CHAR_DEX+ " int(2) NOT NULL, "
                +CHAR_CONS+ " int(2) NOT NULL, "
                +CHAR_INT+ " int2(2) NOT NULL, "
                +CHAR_WIS+ " int(2) NOT NULL, "
                +CHAR_CHAR+ " int(2) NOT NULL, "
                +CHAR_HP+ " int(2) NOT NULL, "
                +CHAR_DESC+ " VARCHAR(255) DEFAULT NULL"
                + ")");
    
    
    
        //banco Personagens
        db.execSQL("CREATE TABLE IF NOT EXISTS "
                +TABLE_PROF+ " ( "
                +PROF_ID + " "+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +PROF_ATL+ " int(3) NOT NULL,"
                +PROF_ACR+ " int(3) NOT NULL,"
                +PROF_FURT+ " int(3) NOT NULL,"
                +PROF_PREST+ " int(3) NOT NULL,"
                +PROF_ARC+ " int(3) NOT NULL,"
                +PROF_HIS+ " int(3) NOT NULL,"
                +PROF_INVES+ " int(3) NOT NULL,"
                +PROF_NATU+ " int(3) NOT NULL,"
                +PROF_RELI+ " int(3) NOT NULL,"
                +PROF_ADES+ " int(3) NOT NULL,"
                +PROF_INTUI+ " int(3) NOT NULL,"
                +PROF_MEDIC+ " int(3) NOT NULL,"
                +PROF_PERCEP+ " int(3) NOT NULL,"
                +PROF_SOBRE+ " int(3) NOT NULL,"
                +PROF_ATUA+ " int(3) NOT NULL,"
                +PROF_ENGANA+ " int(3) NOT NULL,"
                +PROF_INTI+ " int(3) NOT NULL,"
                +PROF_PERSU+ " int(3) NOT NULL"
                + ")");
                    //                                                                                  Nome,nivel,cast time, range, duracao, classe, descrição
        //Insert de personagem pra ele conseguir builda os card
        db.execSQL("INSERT INTO personagens (char_nome, char_nivel, char_raca, char_class, char_back, char_str, char_dex,char_cons, char_int,char_wis,char_char,char_hp,char_desc) VALUES ('Clebinho',1, 'Anão', 'Guerreiro', 'Bandido', 10, 12, 13, 14, 15, 16, 10, 'desc')");

        //Insert dos feitiço no banco
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Chama Sagrada',0,'1 acao', '18 Metros','Instantaneo','Clérigo',' Chamas radiantes caem sobre uma criatura que você possa ver dentro do alcance da magia. O alvo deve passar em um teste de resistência de Destreza ou sofre 1d8 de dano radiante. O alvo não recebe nenhum benefício de cobertura no teste de resistência para essa magia.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Guia' ,0,'1 acao', 'Toque','1 Minuto','Clérigo',' Você toca uma criatura que aceite a magia. Uma vez antes da magia se encerrar, o alvo pode jogar 1d4 e somar o resultado obtido em um teste de atributo à escolha dele. O dado pode ser jogado antes ou depois do resultado do teste de atributo. Após isto, a magia se encerra.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Luz' ,0,'1 acao', 'Toque','1 Hora','Clérigo',' Você toca um objeto não maior do que 3 metros em qualquer dimensão. Até a magia terminar, o objeto emana uma luz plena em um raio de 6 metros em volta do objeto e mais 6 metros adicionais de penumbra. A cor pode ser a que você escolher. Cobrir completamente o objeto com algum objeto opaco bloqueia a luz. A magia termina se você lançá-la de novo ou se a cancelar como uma ação. Se o alvo for um objeto usado ou em posse de uma criatura hostil, a criatura deve passar em um teste de resistência de Destreza para evitar a magia.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Poupar os mortos' ,'0','1 acao', 'Toque','Instantaneo','Clérigo',' Você toca uma criatura viva que tenha 0 pontos de vida. A criatura fica estável. Essa magia não tem efeito em mortos-vivos ou constructos.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Resistencia' ,0,'1 acao', 'Toque','1 Minuto','Clérigo',' Você toca uma criatura que aceite o efeito dessa magia. Uma vez antes da magia terminar, o alvo pode jogar 1d4 e adicionar o resultado a um teste de resistência da escolha dele. Ele pode jogar o dado antes ou depois de fazer um teste de resistência. Então a magia se encerra..')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Taumaturgia' ,0,'1 acao', '9 metros','1 Minuto','Clérigo',' Você manifesta uma maravilha menor, um sinal de poder sobrenatural, dentro do alcance da magia. Você cria um dos seguintes efeitos dentro do alcance da magia: • Sua voz fica três vezes mais alta do que o normal durante 1 minuto. • Você faz com que chamas tremulem, clareiem, escureçam ou mudem de cor por 1 minuto. • Você causa tremores inofensivos no chão durante 1 minuto. • Você cria um som instantâneo que surge em um ponto à sua escolha dentro ao alcance da magia, como o estrondo de um trovão, o gralhar de um corvo ou sussurros sinistros. • Você faz instantaneamente uma porta ou janela destrancada se abrir ou se fechar violentamente. • Você altera a aparência dos seus olhos por 1 minuto. Se lançar essa magia múltiplas vezes, você pode manter até três efeitos de 1 minuto ativos ao mesmo tempo e pode cancelar cada efeito usando uma ação.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Bencao' ,1,'1 acao', '9 metros','1 minuto','Clérigo',' Você toca uma criatura viva que tenha 0 pontos de vida. A criatura fica estável. Essa magia não tem efeito em mortos-vivos ou constructos.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Comando' ,1,'1 acao', '18 metros','1 rodada','Clérigo',' Você profere o comando de uma palavra a uma criatura que possa ver, dentro do alcance da magia. O alvo deve passar em um teste de resistência de Sabedoria ou cumpre a sua ordem no seu próximo turno. A magia não surte efeito se o alvo for um mortovivo, se o alvo não compreender o seu idioma ou se o comando for diretamente nocivo a ele. Abaixo seguem alguns comandos típicos e seus efeitos. Você também pode declarar outro comando que não descrito abaixo. Se assim fizer, é o Mestre quem determina como o alvo se comportará. Se o alvo não puder seguir o seu comando, a magia se encerra. Aproxime-se. O alvo se move para junto de você pela rota mais curta e direta possível, terminado seu turno, caso possa, a 1,5 metros de distância de você. Largue. O alvo solta tudo que estiver segurando e então encerra seu turno. Fuja. O alvo gasta seu turno se movendo para longe de você pelos meios mais rápidos que dispuser. Caia. O alvo se joga ao chão e encerra seu turno. Pare. O alvo não se move e não faz ações. Uma criatura voadora permanece no ar, se puder. Caso a criatura precise se mover para permanecer no ar, ela usa a distância mínima possível para fazê-lo. Em Níveis Superiores. Quando você lança essa magia usando um espaço de magia de 2º nível ou superior, você pode afetar uma criatura adicional para cada nível acima do 1º. As criaturas devem estar a até 9 metros uma das outras quando você lançar a magia.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Curar ferimentos' ,1,'1 acao', 'Toque','Instantaneo','Clérigo','A criatura que você toca recupera pontos de vida igual a 1d8 + o modificador de seu atributo para lançar magias. Essa magia não tem efeito em mortos-vivos ou constructos.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Detectar magia' ,1,'1 acao', 'Voce','10 min','Clérigo',' Durante a duração da magia, você sente a presença de magia a até 9 metros de você. Se você detectar magia dentro desta área, você pode usar sua ação para enxergar uma aura branda em torno de qualquer criatura ou objeto que possua magia, como também descobre a escola da magia, se a tiver. A magia pode transpor a maioria das barreiras, mas é bloqueada por 0,3 metros de pedra, 2,5 cm de metal comum, uma película de chumbo ou 0,9 metros de barro ou sujeira.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Escudo da fe' ,1,'1 acao bonus', '18 metros','10 minutos','Clérigo',' Um campo cintilante surge e envolve uma criatura à sua escolha dentro do alcance da magia, garantindo um bônus de +2 na CA enquanto a magia durar.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Lampejo' ,1,'1 acao', '36 metros','1 rodada','Clérigo',' Um raio de luz irrompe até uma criatura à sua escolha, que esteja dentro do alcance da magia. Se acertar, o alvo sofre 4d6 de dano radiante e a próxima jogada de ataque feita contra ele antes do final do próximo seu próximo turno ganha vantagem, graças a uma penumbra mística resplandecente que fica sobre o alvo.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Inferir ferimentos' ,1,'1 acao', 'Toque','Instantaneo','Clérigo',' Você realiza um ataque corpo a corpo mágico contra uma criatura que você possa tocar. Se acertar, o alvo sofre 3d10 de dano necrótico')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Palavra de cura' ,1,'1 acao', '18 metros','Instantaneo','Clérigo',' Uma criatura à sua escolha que você possa ver, dentro do alcance da magia, recupera pontos de vida equivalentes a 1d4 + o seu modificador de atributo para lançar magia. Essa magia não tem efeito em mortos-vivos ou constructos.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Santuario' ,1,'1 acao bonus', '9 minutos','1 minuto','Clérigo',' Você protege uma criatura dentro do alcance da magia contra ataques. Até o final da magia, qualquer criatura que tenha como alvo a criatura protegida com um ataque ou uma magia prejudicial precisa primeiro fazer um teste de resistência de Sabedoria. Se falhar, a criatura deve escolher um novo alvo ou perde o ataque ou a magia. Essa magia não protege o alvo contra efeitos de área, como uma explosão de uma bola de fogo, por exemplo.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Centelha de fogo' ,0,'1 acao', '36 metros','instantaneo','Mago',' Você arremessa um punhado de fogo em uma criatura ou objeto dentro do alcance da magia. Realize uma jogada de ataque mágico à distância. Se acertar, você causa 1d10 de dano flamejante. Um objeto inflamável acertado por esta magia incendeia se não estiver sendo usado ou carregado.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Globos de luz' ,0,'1 acao', '36 metros','1 minuto','Mago',' Você cria quatro fontes de luz equivalentes a de uma tocha, com a aparência de tochas, lanternas ou orbes brilhantes, que flutuam no ar até o final da magia. Você também pode combiná-las em uma só, em uma forma brilhante e vagamente humanoide de tamanho médio. Independente da forma escolhida, cada fonte de luz emana uma penumbra de 3 metros de raio. ')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Ilusao menor' ,0,'1 acao', '9 metros','1 minuto','Mago',' Você cria o som ou uma imagem de um objeto, dentro do alcance da magia, que dura até o fim da magia. A ilusão também termina se você a cancelar usando uma ação ou se você lançar a magia de novo. Se você criar um som, o volume pode ser de um sussurro até um grito. Pode ser a sua voz, a voz de outra pessoa, o rugido de um leão, uma batida de tambores ou qualquer outro som à sua escolha. O som continua no mesmo volume durante toda a duração da magia ou você pode fazer sons discretos em diferentes momentos durante a duração da magia. Se você cria a imagem de um objeto – como uma cadeira, pegadas lamacentas ou um baú pequeno – a imagem não pode ser maior do que um cubo de 1,5 metros de lado. A imagem não pode criar som, luz, cheiro, ou qualquer outro efeito sensorial. Interações físicas com a imagem a revelam como uma ilusão, porque qualquer coisa pode passar através dela. Se uma criatura usar uma ação para observar o som ou a imagem, a criatura pode determinar que se trata de uma ilusão se passar em um teste de Inteligência (Investigação) contra a CD de suas magias. Se uma criatura identificar a ilusão, a mesma torna-se quase imperceptível para ela.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Rajada de veneno' ,0,'1 acao', '3 metros','Instantaneo','Mago',' Você estende sua mão na direção de uma criatura que possa ver, dentro do alcance da magia, e projeta uma rajada de gás nocivo da palma de sua mão. A criatura deve passar em um TR de Constituição ou sofre 1d12 de dano venenoso.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Luz' ,0,'1 minuto', 'Toque','1 Hora','Mago',' Você toca um objeto não maior do que 3 metros em qualquer dimensão. Até a magia terminar, o objeto emana uma luz plena em um raio de 6 metros em volta do objeto e mais 6 metros adicionais de penumbra. A cor pode ser a que você escolher. Cobrir completamente o objeto com algum objeto opaco bloqueia a luz. A magia termina se você lançá-la de novo ou se a cancelar como uma ação. Se o alvo for um objeto usado ou em posse de uma criatura hostil, a criatura deve passar em um teste de resistência de Destreza para evitar a magia.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Maos magicas' ,0,'1 acao', '9 metros','1 minuto','Mago',' Uma mão espectral flutuante surge no ponto que você escolher, dentro do alcance da magia. A mão permanece pela duração da magia ou até você a cancelar como uma ação. A mão desaparece ao se distanciar mais do que 9 metros para longe de você ou caso você lance a magia de novo. Você pode usar sua ação para controlar a mão. Você pode usar a mão para manipular um objeto, abrir uma porta ou recipiente destrancado, arrumar ou apanhar um objeto de um recipiente destrancado, ou derramar o conteúdo de um frasco. Você pode mover a mão 9 metros cada vez que a usar. A mão não pode atacar, ativar itens mágicos ou carregar mais do que 5 kg.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Orbe acido' ,0,'1 acao', '18 metros','instantaneo','Mago',' Você arremessa uma bolha de ácido. No alcance da magia, escolha uma criatura, ou duas a até 1,5 metros uma da outra. Um alvo deve passar em um teste de resistência de Destreza ou sofrer 1d6 de dano ácido.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Prestidigitacao' ,0,'1 acao', '3 metros','1 Hora','Mago', ' Esta magia é um truque mágico simples que os aprendizes usam para praticar magia. Você cria um dos seguintes efeitos mágicos dentro do alcance da magia: • Você cria um inofensivo e instantâneo efeito sensorial, uma chuva de faíscas, uma lufada de vento, notas musicais ou um odor estranho. • Você instantaneamente acende ou apaga uma vela, uma tocha ou uma pequena fogueira. • Você instantaneamente limpa ou suja um objeto inanimado que não seja maior do que um cubo de 0,3 metros de lado. • Você instantaneamente resfria, aquece ou confere sabor a um objeto inanimado não maior que um cubo de 0,3 metros de lado. • Você produz uma cor, uma pequena marca ou um símbolo em um objeto ou superfície que dura 1 hora. 139 • Você cria uma bugiganga não mágica ou uma imagem ilusória, que caiba em sua mão e com duração até o final do seu próximo turno. Se você lançar essa magia múltiplas vezes, você pode ter até três efeitos não instantâneos ativos ao mesmo tempo, e você pode cancelar cada efeito usando uma ação.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Raio de gelo' ,0,'1 acao', '18 metros','instantanea','Mago',' Uma luz frígida branco-azulada em forma de raio parte na direção de uma criatura dentro do alcance da magia. Você faz uma jogada de ataque mágico à distância contra o alvo. Se acertar, o alvo sofre 1d8 de dano congelante e seu deslocamento é reduzido em 3 metros até o começo do próximo turno você.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Toque chocante' ,0,'1 acao', 'Toque','instantanea','Mago',' Relâmpagos saem de suas mãos para eletrocutar uma criatura que você tenta tocar. Você deve fazer uma jogada de ataque mágico corpo a corpo contra o alvo. Você possui vantagem no ataque caso o alvo esteja usando alguma armadura feita de metal. Se acertar, o alvo sofre 1d8 de dano elétrico, e não pode ter reações até o começo de seu próximo turno.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Armadura arcana' ,1,'1 acao', 'toque','8 horas','Mago',' Você toca uma criatura que aceita essa magia e que não esteja usando armadura. Uma força mágica protetora envolve o alvo até a magia terminar. A CA base do alvo torna-se 13 + modificador de Destreza. A magia termina se o alvo vestir uma armadura ou se você a cancelar como uma ação.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Compreender idiomas' ,1,'1 acao', 'voce','1 hora','Mago',' Enquanto durar a magia você compreende o sentido literal de qualquer idioma falado que ouvir. Você também compreende qualquer idioma escrito que ver, mas deve tocar a superfície que as palavras foram escritas. Leva-se em torno de 1 minuto para ler uma página de texto. Essa magia não decodifica mensagens secretas em um texto ou símbolo, como sigilo arcano, o qual não é parte de um idioma escrito.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Detectar magia' ,1,'1 acao', 'Voce','10 minutos','Mago',' Durante a duração da magia, você sente a presença de magia a até 9 metros de você. Se você detectar magia dentro desta área, você pode usar sua ação para enxergar uma aura branda em torno de qualquer criatura ou objeto que possua magia, como também descobre a escola da magia, se a tiver. A magia pode transpor a maioria das barreiras, mas é bloqueada por 0,3 metros de pedra, 2,5 cm de metal comum, uma película de chumbo ou 0,9 metros de barro ou sujeira.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Enfeiticar pessoas' ,1,'1 acao', '9 metros','1 hora','Mago',' Você tenta enfeitiçar um humanoide que você possa ver no alcance da magia. O humanoide deve fazer um teste de resistência de Sabedoria, tendo vantagem se você ou seus companheiros estejam lutando contra ele. Se falhar, ele está enfeitiçado por você até a magia terminar ou até você ou um de seus companheiros fizer algo que o cause dano. A criatura enfeitiçada trata você como um conhecido amigável. Quando a magia se encerra, a criatura sabe que foi enfeitiçada por você.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Escudo arcano' ,1,'1 reacao', 'voce','1 rodada','Mago',' Uma barreira invisível de força mágica surge e protege você. Até o começo do seu próximo turno, você ganha um bônus de +5 na CA, inclusive contra ataques preparados, e você não sofre dano dos mísseis mágicos.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Indentificacao' ,1,'1 minuto', 'toque','instantaneo','Mago',' Você escolhe um objeto que você deve tocar durante todo o tempo para lançar a magia. Se for um item mágico ou algum outro objeto imbuído de magia, você aprende suas propriedades e descobre como utilizálo, se há algum vínculo necessário para seu uso, bem como quantas cargas ele possui, se tiver. Você descobre quaisquer magias que estejam afetando o item e quais são. Se o item foi criado por uma magia, você descobre qual a magia que o criou. Se ao invés disso você tocar uma criatura durante o lançar dessa magia, você descobre quais os efeitos mágicos que estão aplicados sobre ela, se houver')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Imagem silenciosa' ,1,'1 acao', '18 metros','10 minutos','Mago',' Você cria a imagem de um objeto, uma criatura ou outro fenômeno visível que não seja maior do que um cubo de 4,5 metros de lado. Essa imagem surge em um ponto dentro do alcance da magia e dura até o fim da magia. Essa imagem é puramente visual, não é acompanhada por sons, cheiros ou quaisquer outros efeitos sensoriais. Você pode usar sua ação para mover a imagem para qualquer ponto dentro do alcance da magia. Se a imagem muda de localização, você pode alterar a aparência dela para que seu movimento aparente ser natural. Por exemplo, se você cria uma imagem de uma criatura e a move, você pode alterar a imagem para que pareça que ela está andando. Interações físicas com a imagem a revelam como uma ilusão, porque qualquer coisa pode passar através dela. Se uma criatura usar uma ação para observar o som ou a imagem, a criatura pode determinar que se trata de uma ilusão se passar em um teste de Inteligência (Investigação) contra a CD de suas magias. Se uma criatura identificar a ilusão, a mesma se torna translúcida para ela.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Maos flamejantes' ,1,'1 acao', '4.5 metros','instantaneo','Mago',' A medida que você firma as mãos, tocando os polegares e com os dedos abertos, um fino manto de chamas sai da ponta dos seus dedos esticados. Cada criatura em um cone de 4,5 metros deve fazer um teste de resistência de Destreza. Se falhar, o alvo sofre 3d6 de dano flamejante, ou metade se passar. O fogo incendeia qualquer objeto inflamável no espaço, desde que não esteja sendo vestido ou carregado..')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Misseis magicos' ,1,'1 acao', '36 metros','Instantaneo','Mago',' Você cria três dardos brilhantes de energia mágica. Cada dardo acerta uma criatura que você possa ver, dentro do alcance da magia. Cada dardo causa 1d4 + 1 de dano de força ao alvo. Todos os dardos atacam simultaneamente, e você pode direcioná-los para um único alvo ou diversos.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Onda trovejante' ,1,'1 acao', '4.5 metros','Instantaneo','Mago',' Uma onda de força trovejante parte de você. Cada criatura dentro do espaço de um cubo de 4,5 metros de lado, tendo você como origem, precisa fazer um teste de resistência de Constituição. Se falhar, a criatura sofre 2d8 de dano trovejante e é empurrada 3 metros para longe de você. Se passar, a criatura sofre metade do dano e não é empurrada. Além disso, objetos não empunhados que estejam completamente dentro do espaço de efeito são automaticamente empurrados 3 metros de distância para longe de você, devido ao efeito da magia. A magia emite um estrondo trovejante audível a até 90 metros.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Sono' ,1,'1 acao', '27 metros','1 minuto','Mago',' Esta magia põe criaturas em um entorpecimento mágico. Jogue 5d8. O resultado total indica quantos pontos de vidas das criaturas a magia consegue afetar. Criaturas a até 6 metros do ponto de origem em que você escolheu, dentro do alcance da magia, são afetadas em ordem ascendente dos seus pontos de vida atuais (ignorando criaturas inconscientes). Começando pela criatura que tem pontos de vida atuais mais baixo, cada criatura afetada por essa magia cai inconsciente até o final da duração, ou até ela sofrer dano, ou se alguém gastar uma ação para chacoalhar ou esbofetear a criatura adormecida para acordá-la. Subtraia os pontos de vida atuais de cada criatura afetada do total dos dados antes de seguir para a próxima criatura com menor valor de pontos de vida atuais. Os pontos de vida atuais da criatura devem ser iguais ou menor do que o valor restante do total dos dados para que a criatura possa ser afetada. Mortos-vivos e criaturas imunes à condição enfeitiçado são imunes a essa magia.')");
        db.execSQL("INSERT INTO  feiticos (name,nivel,castTime,range,duration,classe,descricao) VALUES ('Transformacao momentanea' ,1,'1 acao', 'Voce','1 hora','Mago',' Você se disfarça – incluindo sua roupa, sua armadura, armas e outros pertences – com uma aparência diferente até a magia encerrar ou até você usar uma ação para dissipá-la. Você pode aparentar ser 0,3 metros maior ou menor, e pode aparentar ser magro, gordo ou um estado entre os dois. Você não pode mudar seu tipo de corpo, logo, precisa adotar uma forma que possua o modelo básico dos seus membros. Do contrário, essa extensão da ilusão fica por sua conta. As mudanças ocorridas por essa magia falham se inspecionadas fisicamente. Por exemplo, se você usar essa magia para adicionar um chapéu à sua indumentária, objetos podem passar através do chapéu e qualquer um que o tocar não sentirá nada, ou só sentirá sua cabeça e seus cabelos. Se você usar essa magia para aparentar ser mais magro do que é, a mão de alguém que tentasse alcançar você, ao invés de colidir com você ficaria suspensa no ar. Para discernir que você está disfarçado, uma criatura pode usar sua ação para inspecionar sua aparência e precisa passar em um teste de Inteligência (Investigação) contra a CD de suas magias.')");


}

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SPELLS);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHAR);
//        onCreate(db);
    }
}

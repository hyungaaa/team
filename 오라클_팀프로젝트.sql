CREATE TABLE user_info (
    uuid VARCHAR2(20) NOT NULL,
    ccode VARCHAR2(20) NOT NULL,
    upass VARCHAR2(20),
    uname VARCHAR2(20),
    utel VARCHAR2(20),
    uemail VARCHAR2(20),
    unum VARCHAR2(20),
    uposition VARCHAR2(20),
    ubirth DATE,
    uimage VARCHAR2(20),
    udate VARCHAR2(20),
    umaster VARCHAR2(1) CHECK (umaster = '1' OR umaster = '2')
);

CREATE TABLE center_list (
	ccode	varchar2(20)		NOT NULL,
	cname	varchar2(20)		NOT NULL,
	cmanager	varchar2(20),
	ctel	varchar2(20)
);
CREATE TABLE bd_list (
	bno	number(8)		NOT NULL,
	uuid	varchar2(20)		NOT NULL,
	pnum	varchar2(20)		NOT NULL,
	btitle	varchar2(20),
	bdate	varchar2(20),
	bbits	number(8),
	bimage	varchar2(20),
	btext	varchar2(1000)
);

CREATE TABLE bd_re (
	breno	number(8)		NOT NULL,
	bno	number(8)		NOT NULL,
	bretext	varchar2(20),
	uuid	varchar2(20)		NOT NULL
);

CREATE TABLE pd_list (
	pnum	varchar2(20)		NOT NULL,
	bcid	varchar2(20),
	wzone	varchar2(20)		NOT NULL,
	pname	varchar2(20)		NOT NULL,
	pday	varchar2(20),
	punit	varchar2(20),
	pamount	number(5),
	psize	varchar2(20)
);

CREATE TABLE req_list (
	rid	varchar2(20)		NOT NULL,
	uuid	varchar2(20)		NOT NULL,
	rcategory	varchar2(20)
);

CREATE TABLE wh_list (
	wzone	varchar2(20)		NOT NULL,
	wclass	varchar2(20),
	wsize	varchar2(20),
	wcnt	number(8),
	wall	number(8),
	wmanager	varchar2(20),
	wnote	varchar2(20)
);

CREATE TABLE user_power (
	uuid	varchar2(20)		NOT NULL,
	ulevel	varchar2(20),
	updv	varchar2(1) CHECK (updv = '1' OR updv = '2'),
	updior	varchar2(1) CHECK (updior = '1' OR updior = '2'),
	updr	varchar2(1) CHECK (updr = '1' OR updr = '2'),
	updiom	varchar2(1) CHECK (updiom = '1' OR updiom = '2'),
	ubdm	varchar2(1) CHECK (ubdm = '1' OR ubdm = '2'),
	uum	varchar2(1) CHECK (uum = '1' OR uum = '2')	
);

CREATE TABLE pd_out (
	poutseq	number(12)		NOT NULL,
	plot	varchar2(20),
	poutdate	date,
	poutcnt	number(12)
);

CREATE TABLE pd_in (
	plot	varchar2(20),
	pnum	varchar2(20)		NOT NULL,
	wzone	varchar2(20)		NOT NULL,
	pindate	date,
	pincnt	number(12),
	pnote	varchar2(20)
);

CREATE TABLE big_cat (
	bcid	varchar2(20),
	bceasy	varchar2(20),
	bcsnack	varchar2(20),
	bcice	varchar2(20),
	bcfood	varchar2(20),
	bcbeverage	varchar2(20)
);

CREATE TABLE small_cat (
	scid	varchar2(20),
	bcid	varchar2(20),
	scd	varchar2(20),
	scs	varchar2(20),
	scj	varchar2(20),
	sce	varchar2(20)
);

ALTER TABLE user_info ADD CONSTRAINT PK_USER_INFO PRIMARY KEY (
	uuid
);

ALTER TABLE center_list ADD CONSTRAINT PK_CENTER_LIST PRIMARY KEY (
	ccode
);

ALTER TABLE bd_list ADD CONSTRAINT PK_BD_LIST PRIMARY KEY (
	bno
);

ALTER TABLE bd_re ADD CONSTRAINT PK_BD_RE PRIMARY KEY (
	breno
);

ALTER TABLE pd_list ADD CONSTRAINT PK_PD_LIST PRIMARY KEY (
	pnum
);

ALTER TABLE req_list ADD CONSTRAINT PK_REQ_LIST PRIMARY KEY (
	rid
);

ALTER TABLE wh_list ADD CONSTRAINT PK_WH_LIST PRIMARY KEY (
	wzone
);

ALTER TABLE user_power ADD CONSTRAINT PK_USER_POWER PRIMARY KEY (
	uuid
);

ALTER TABLE pd_out ADD CONSTRAINT PK_PD_OUT PRIMARY KEY (
	poutseq
);

ALTER TABLE pd_in ADD CONSTRAINT PK_PD_IN PRIMARY KEY (
	plot
);

ALTER TABLE big_cat ADD CONSTRAINT PK_BIG_CAT PRIMARY KEY (
	bcid
);

ALTER TABLE small_cat ADD CONSTRAINT PK_SMALL_CAT PRIMARY KEY (
	scid
);

ALTER TABLE user_power ADD CONSTRAINT FK_user_info_TO_user_power_1 FOREIGN KEY (
	uuid
)
REFERENCES user_info (
	uuid
);







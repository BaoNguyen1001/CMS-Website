--
-- Database: `cmsdb`
--
CREATE DATABASE CMSDB;

USE CMSDB;
-- --------------------------------------------------------

--
-- Table structure for table `content`
--


CREATE TABLE  content (
  id int NOT NULL AUTO_INCREMENT,
  title varchar(200) NOT NULL,
  brief varchar(150) NOT NULL,
  content varchar(1000) NOT NULL,
  createDate datetime DEFAULT NULL,
  updateTime datetime DEFAULT NULL,
  sort varchar(100) DEFAULT '0',
  authorid int NOT NULL,
  PRIMARY KEY (id)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `content`
--

INSERT INTO content ( title, brief, content, createDate, updateTime, sort, authorid) VALUES
('title 1', 'this is brief', 'no content', '2016-08-31 10:24:30', '2021-08-31 13:13:13', 'sort 1', 3),
( 'HCMUTE', ' Ho Chi Minh City University of Technology and Education', 'is a multidisciplinary university in Vietnam, with strengths in technical training, is considered as one of the leading technical universities in engineering training in the South.', '2021-10-22 10:45:25', '2021-10-22 22:13:24', 'sort 2', 2),
( 'IT', ' Information technology ', 'is a branch of engineering that uses computers and computer software to convert, store, protect, process, transmit, and collect information.', '2021-10-22 10:47:25', '2021-10-22 14:13:24', 'sort 2', 1),
( 'AI', 'artificial intelligence', 'is intelligence demonstrated by machines, as opposed to natural human intelligence.', '2021-10-22 15:13:15', '2021-10-22 17:16:24', 'sort', 1),
( 'ML', 'Machine learning', ' is the study of computer algorithms that can improve automatically through experience and by the use of data.', '2021-10-22 11:23:45', '2021-10-22 15:16:23', 'sort', 1);

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE  member (
  id int NOT NULL AUTO_INCREMENT,
  firstname varchar(30) DEFAULT NULL,
  lastname varchar(30) DEFAULT NULL,
  username varchar(30) NOT NULL,
  password varchar(30) NOT NULL,
  phone char(13) DEFAULT NULL,
  email varchar(100) NOT NULL,
  description varchar(200) DEFAULT NULL,
  createdDate datetime DEFAULT NULL,
  updateTime datetime DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


ALTER TABLE content ADD CONSTRAINT fk_author FOREIGN KEY(authorid) REFERENCES member(id);

--
-- Dumping data for table `member`
--

INSERT INTO member ( firstname, lastname, username, password, phone, email, description, createdDate, updateTime) VALUES
('kha', 'dieu', 'khadieu', '1311', '012345678', 'dieu1311@gmail.com', 'no decription', '2021-10-22 14:16:25', '2021-10-25 01:31:06'),
('bao', 'nguyen', 'baobao', '123', '0123456789', 'baobao@gmail.com', 'team leader', '2021-10-22 12:12:12', '2021-10-25 23:27:15'),
('dat', 'thanh', 'datthanh', 'abc', '0123456', 'uesr1@gmail.com', 'test login', '2021-10-22 13:11:25', '2021-10-22 16:27:35'),
('thanh', 'tung', 'thanhtung', 'abc', '01234567', 'uesr2@gmail.com', 'test login', '2021-10-22 07:36:10', '2021-10-25 18:30:15'),
('thanh', 'phuong', 'thanhphuong', 'abc', '012345678', 'uesr3@gmail.com', 'test login', '2021-10-22 08:58:39', '2021-10-25 19:02:05');
COMMIT;


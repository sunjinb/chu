import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { OpenVidu } from 'openvidu-browser';
import Header from "./components/Common/Header";
import Home from "./Routes/Home";
import DesignerDetail from "./Routes/DesignerPage/DesignerDetail";
import ViduRoom from "./components/OpenVidu/ViduRoom";
import CustomerSignUp from "./Routes/SignUpPage/CutomerSignUp";
import DesignerSignUp from "./Routes/SignUpPage/DesignerSignUp";
import Complete from "./Routes/SignUpPage/Complete";
import LogIn from "./Routes/LogInPage/LogIn";
import FindId from "./Routes/LogInPage/FindId";
import FoundId from "./Routes/LogInPage/FoundId";
import AuthNum from "./Routes/LogInPage/AuthNum";
import UserType from "./Routes/SignUpPage/UserType";
import FindPw from "./Routes/LogInPage/FindPw";
import ChangePw from "./Routes/LogInPage/ChangePw";
import WorldcupImgUpload from "./Routes/WorldCupPage/WorldcupImgUpload";
import CustomerMyPage from "./Routes/CustomerPage/CustomerMyPage";
import DesignerMyPage from "./Routes/DesignerPage/DesignerMyPage";
import ListView from "./Routes/ViewPage/ListView";
import Survey from "./components/ModalComponent/Survey";
import Result from "./components/ModalComponent/Result";
import EditDesignerInfo from "./Routes/DesignerPage/EditDesignerInfo";
import EditCustomerInfo from "./Routes/CustomerPage/EditCustomerInfo";
import Reservation from "./Routes/DesignerPage/Reservation";

function App() {
  return (
    <Router>
      <Header/>
      <Routes>
        <Route path="/" element={<Home/>} />
        <Route path="/viduroom" element={<ViduRoom/>} />
        <Route path="login" element={<LogIn/>} />
        <Route path="findid" element={<FindId/>} />
        <Route path="findpw" element={<FindPw/>}/>
        <Route path="authnum" element={<AuthNum/>} />
        <Route path="foundid" element={<FoundId/>} />
        <Route path="changepw" element={<ChangePw/>} />
        <Route path="usertype" element={<UserType/>} />
        <Route path="customersignup" element={<CustomerSignUp/>} />
        <Route path="designersignup" element={<DesignerSignUp/>} />
        <Route path="complete" element={<Complete/>} />
        <Route path="designerdetail" element={<DesignerDetail/>} />
        <Route path="worlducupimgupload" element={<WorldcupImgUpload/>} />
        <Route path="customermypage" element={<CustomerMyPage/>} >
          <Route path="result/:designerSeq" element={<CustomerMyPage/>} />
        </Route>
        <Route path="editcustomerinfo" element={<EditCustomerInfo/>} />
        <Route path="designermypage" element={<DesignerMyPage/>} />
        <Route path="listview" element={<ListView/>} />
        <Route path="editdesignerinfo" element={<EditDesignerInfo/>} />
        <Route path="reservation" element={<Reservation/>} />
        <Route path="/modaltest" element={<Survey/>}>
          <Route path="/modaltest/1" element={<Survey/>}/>
        </Route>
        {/* <Route path="/result" element={<Result/>}>
          <Route path="/result/1" element={<Result/>}/>
        </Route> */}
      </Routes>
    </Router>
  )
};

export default App;


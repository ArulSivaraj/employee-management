import { Routes, Route } from "react-router-dom";

import Login from "../login/Login";
import Signup from "../login/Signup";

const AppRoutes = () => {
    return (
        <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/login" element={<Login />} />
            <Route path="/signup" element={<Signup />} />
        </Routes>
    );
};

export default AppRoutes;
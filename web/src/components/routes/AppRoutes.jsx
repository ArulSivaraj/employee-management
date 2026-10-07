import { Routes, Route } from "react-router-dom";

import Login from "../login/Login";
import Signup from "../login/Signup";
import ProtectedRoute from "./ProtectedRoute";
import Dashboard from "../organization/Organization";

const AppRoutes = () => {
    return (
        <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/login" element={<Login />} />
            <Route path="/signup" element={<Signup />} />

            <Route element={<ProtectedRoute />}>
                <Route
                    path="/organization"
                    element={<Dashboard />}
                />
            </Route>

        </Routes>
    );
};

export default AppRoutes;
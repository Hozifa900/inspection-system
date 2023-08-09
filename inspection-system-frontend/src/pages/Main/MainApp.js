import "bootstrap/dist/css/bootstrap.min.css";
import {Route, Routes, useResolvedPath} from "react-router-dom";
import Login from "../Login/Login";
import Home from "../Home/Home";
import {memo} from "react";
import PrivateRoute from "../../components/PrivateRoute/PrivateRoute";
import {ROLE_ADMIN, ROLE_INSPECTOR, ROLE_MANAGER} from "../../constants/Security";
import User from "../User";
import Task from "../Task";
import Report from "../Report";

function MainApp() {
    const match = useResolvedPath("");

    return (
        <Routes>
            <Route path="auth/signin" element={<Login/>}/>
            <Route path={match.pathname}
                   element={
                <PrivateRoute roles={[ROLE_ADMIN, ROLE_MANAGER, ROLE_INSPECTOR]}>
                    <Home/>
                </PrivateRoute>}

            />
            <Route
                path="user"
                element={
                    <PrivateRoute roles={[ROLE_ADMIN]}>
                        <User />
                    </PrivateRoute>
                }
            />
            <Route
                path="inspector"
                element={
                    <PrivateRoute roles={[ROLE_MANAGER]}>
                        <User />
                    </PrivateRoute>
                }
            />
            <Route
                path="task"
                element={
                    <PrivateRoute roles={[ROLE_MANAGER, ROLE_ADMIN]}>
                        <Task />
                    </PrivateRoute>
                }
            />
            <Route
                path="report"
                element={
                    <PrivateRoute roles={[ROLE_MANAGER, ROLE_ADMIN]}>
                        <Report />
                    </PrivateRoute>
                }
            />
        </Routes>

    );
}

export default memo(MainApp);

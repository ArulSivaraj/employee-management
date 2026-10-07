import { useState } from "react";
import {
    Box,
    Button,
    Checkbox,
    Container,
    FormControlLabel,
    IconButton,
    InputAdornment,
    Paper,
    TextField,
    Typography,
} from "@mui/material";

import { Visibility, VisibilityOff } from "@mui/icons-material";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function Login() {
    const [showPassword, setShowPassword] = useState(false);

    const [formData, setFormData] = useState({
        email: "",
        password: "",
    });

    const navigate = useNavigate();

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value,
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        console.log(formData);

        try {
            const res = await axios.post(
                "https://sturdy-bassoon-v66667wq6ww43p97x-8080.app.github.dev/users/login",
                {
                    email: formData.email,
                    password: formData.password
                }
            );

            if (res.status) {
                console.log(res);
                localStorage.setItem("token", res.data.token);
                localStorage.setItem("userid", res.data.userid);
                navigate("/organization");
            }
        } catch (e) {
            console.error("API Error Occured :", e);
        }
    };

    const handleSignup = () => {
        navigate("/signup");
    }

    return (
        <Box
            sx={{
                // marginTop: "10%",
                minHeight: "100%",
                display: "flex",
                flexDirection: "row",
                alignItems: "center",
                justifyContent: "center",
                padding: 2,
            }}
        >
            <Container maxWidth="sm">
                {/* Header */}
                <Box textAlign="center" mb={4}>
                    <Typography variant="h4" fontWeight="bold" gutterBottom>
                        Welcome Back
                    </Typography>

                    <Typography variant="body2" color="text.secondary">
                        Login to your account
                    </Typography>
                </Box>

                {/* Form */}
                <Box component="form" onSubmit={handleSubmit}>
                    <TextField
                        fullWidth
                        label="Email"
                        name="email"
                        type="email"
                        value={formData.email}
                        onChange={handleChange}
                        margin="normal"
                        required
                    />

                    <TextField
                        fullWidth
                        label="Password"
                        name="password"
                        type={showPassword ? "text" : "password"}
                        value={formData.password}
                        onChange={handleChange}
                        margin="normal"
                        required
                        InputProps={{
                            endAdornment: (
                                <InputAdornment position="end">
                                    <IconButton
                                        onClick={() => setShowPassword(!showPassword)}
                                        edge="end"
                                    >
                                        {showPassword ? <VisibilityOff /> : <Visibility />}
                                    </IconButton>
                                </InputAdornment>
                            ),
                        }}
                    />

                    {/* Remember + Forgot Password */}
                    <Box
                        sx={{
                            display: "flex",
                            justifyContent: "space-between",
                            alignItems: "center",
                            mt: 1,
                        }}
                    >
                        <FormControlLabel
                            control={<Checkbox />}
                            label="Remember me"
                        />

                        <Typography
                            variant="body2"
                            sx={{
                                color: "primary.main",
                                cursor: "pointer",
                            }}
                        >
                            Forgot password?
                        </Typography>
                    </Box>

                    {/* Login Button */}
                    <Button
                        type="submit"
                        fullWidth
                        variant="contained"
                        size="large"
                        sx={{
                            mt: 2,
                            py: 1.5,
                            borderRadius: 2,
                            textTransform: "none",
                            fontSize: "16px",
                            fontWeight: "bold",
                        }}
                    >
                        Login
                    </Button>

                    {/* Register */}
                    <Typography
                        variant="body2"
                        textAlign="center"
                        sx={{ mt: 3 }}
                    >
                        Don't have an account?{" "}
                        <Box
                            component="span"
                            onClick={handleSignup}
                            sx={{
                                color: "primary.main",
                                fontWeight: "bold",
                                cursor: "pointer",
                            }}
                        >
                            Register
                        </Box>
                    </Typography>
                </Box>
            </Container>
        </Box>
    );
}

export default Login;
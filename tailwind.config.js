/** @type {import('tailwindcss').Config} */
module.exports = {
    content: ["./src/clj/*.clj", "./src/clj/*.edn"],
    theme: {
        extend: {
            colors: {
                white: "#fff",
                dimgray: "#666",
                gray: "#111",
            },
            fontFamily: {
                roboto: "Roboto",
                nunito: "Nunito"
            },
            listStyleType: {
                "dash": "'-'"
            },
            spacing: {
                m: "0.3rem",
                s: "0.2rem",
                xxl: "1.5rem"
            }
        },
        lineHeight: {
            "110": "110%",
            "120": "120%",
            "140": "140%",
            "148": "148%",
            "152": "152.62%"
        },
        fontSize: {
            body: "1.25rem",
            body2: "1.13rem",
            "h1": "1.5rem",
            "h2": "1.38rem",
            "h3": "1.25rem",/*body 1*/
            lg: "1.13rem",
            base: "1rem",
            xl: "1.25rem",
            "3xl": "1.38rem",
            "5xl": "1.5rem",
            name: "3.75rem"

        },
        width: {
            "44": "44.75rem",
            "21": "21.25rem",
            full: "100%"

        },
        gap: {
            "5": "5rem",
            "025": "0.25rem",
            "25": "2.5rem",
            "013": "0.13rem"
        }
    },
    corePlugins: {
        preflight: false,
    },
};

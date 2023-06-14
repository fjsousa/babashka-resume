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
        },
        lineHeight: {
            "120": "120%",
            "140": "140%",
            "148": "148%",
            "152": "152.62%"
        },
        fontSize: {
            lg: "1.13rem",
            base: "1rem",
            xl: "1.25rem",
            "3xl": "1.38rem",
            "5xl": "1.5rem",
            mega: "3.75rem"

        },
        width: {
            "44": "44.75rem",
            "21": "21.25rem"
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

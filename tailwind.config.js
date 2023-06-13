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
                inter: "Inter",
                "playfair-display": "'Playfair Display'",
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
    },
    corePlugins: {
        preflight: false,
    },
};

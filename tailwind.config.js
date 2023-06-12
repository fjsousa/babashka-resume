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
        fontSize: {
            lg: "1.13rem",
            base: "1rem",
            xl: "1.25rem",
            "5xl": "1.5rem",
            "3xl": "1.38rem",
        },
    },
    corePlugins: {
        preflight: false,
    },
};
